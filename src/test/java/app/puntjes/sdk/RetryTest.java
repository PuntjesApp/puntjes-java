package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import app.puntjes.sdk.auth.AccessToken;
import app.puntjes.sdk.auth.TokenStore;
import app.puntjes.sdk.exceptions.PlanLimitExceededException;
import app.puntjes.sdk.exceptions.RateLimitException;
import app.puntjes.sdk.exceptions.ServerException;
import app.puntjes.sdk.exceptions.TransportException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.generated.models.CreateTransactionData;
import app.puntjes.sdk.generated.models.UpdateProductData;
import app.puntjes.sdk.generated.models.UpsertProductData;
import app.puntjes.sdk.support.ApiServer;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class RetryTest {
    private static final String CAMPAIGNS = "{\"data\":{\"data\":[],\"meta\":{\"current_page\":1}}}";

    private final List<Duration> waits = new ArrayList<>();
    private ApiServer server;

    @BeforeEach
    void startServer() {
        server = new ApiServer();
    }

    @AfterEach
    void stopServer() throws IOException {
        server.close();
    }

    @Test
    void aGetRetriesAfterA503AndWaitsTheBaseDelay() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, CAMPAIGNS);

        client(2).campaigns().get();

        assertEquals(2, apiRequests().size());
        assertEquals(List.of(Duration.ofMillis(500)), waits);
    }

    @Test
    void aGetThatKeepsFailingStopsAfterTheRetriesAndDoublesTheWait() {
        for (int i = 0; i < 4; i++) {
            server.enqueueError(500, "INTERNAL_ERROR");
        }

        assertThrowsExactly(ServerException.class, () -> client(2).campaigns().get());

        assertEquals(3, apiRequests().size());
        assertEquals(List.of(Duration.ofMillis(500), Duration.ofMillis(1000)), waits);
    }

    @Test
    void aPostWithAnIdempotencyKeyRetries() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(201, "{\"data\":{}}");
        CreateTransactionData body = new CreateTransactionData();
        body.setIdempotencyKey("key-1");

        client(2).transactions().post(body);

        List<RecordedRequest> sent = apiRequests();
        assertEquals(2, sent.size());
        assertEquals(sent.get(0).getBody().readUtf8(), sent.get(1).getBody().readUtf8());
    }

    @Test
    void aPostWithoutAnIdempotencyKeyIsSentOnceAfterA503() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(201, "{\"data\":{}}");

        assertThrowsExactly(ServerException.class, () -> client(2).transactions().post(new CreateTransactionData()));

        assertEquals(1, apiRequests().size());
        assertEquals(List.of(), waits);
    }

    @Test
    void aPostWithoutAnIdempotencyKeyIsSentOnceAfterANetworkFailure() {
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
        server.enqueueJson(201, "{\"data\":{}}");

        assertThrowsExactly(TransportException.class, () -> client(2).transactions().post(new CreateTransactionData()));

        assertEquals(1, apiRequests().size());
        assertEquals(List.of(), waits);
    }

    @Test
    void aPostWithoutAnIdempotencyKeyIsNotResentOnAPooledConnectionThatDies() {
        server.enqueueJson(200, CAMPAIGNS);
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
        server.enqueueJson(201, "{\"data\":{}}");
        PuntjesClient client = client(2);

        client.campaigns().get();
        assertThrowsExactly(TransportException.class, () -> client.transactions().post(new CreateTransactionData()));

        assertEquals(List.of("GET", "POST"), apiRequests().stream().map(RecordedRequest::getMethod).toList());
    }

    @Test
    void aCancelledCallIsNotRetried() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, CAMPAIGNS);
        Call[] call = new Call[1];
        PuntjesOptions options = PuntjesOptions.builder().maxRetries(2).sleeper(wait -> {
            waits.add(wait);
            call[0].cancel();
        }).build();
        OkHttpClient http = new OkHttpClient.Builder().addInterceptor(new RetryInterceptor(options)).build();
        call[0] = http.newCall(new Request.Builder().url(server.baseUrl() + "/campaigns").build());

        assertThrows(IOException.class, call[0]::execute);

        assertEquals(1, waits.size());
        assertEquals(1, apiRequests().size());
    }

    @Test
    void aPostWithABlankIdempotencyKeyIsSentOnce() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(201, "{\"data\":{}}");
        CreateTransactionData body = new CreateTransactionData();
        body.setIdempotencyKey("");

        assertThrowsExactly(ServerException.class, () -> client(2).transactions().post(body));

        assertEquals(1, apiRequests().size());
    }

    @Test
    void aRateLimitWaitsTheSecondsOfRetryAfter() {
        server.enqueue(new MockResponse().setResponseCode(429).setHeader("Retry-After", "3")
                .setBody("{\"error\":{\"code\":\"RATE_LIMITED\",\"message\":\"Slow down.\"}}"));
        server.enqueueJson(200, CAMPAIGNS);

        client(2).campaigns().get();

        assertEquals(List.of(Duration.ofSeconds(3)), waits);
        assertEquals(2, apiRequests().size());
    }

    @Test
    void aRateLimitThatNeverEndsReachesTheCallerWithItsCodeAndRetryAfter() {
        for (int i = 0; i < 3; i++) {
            server.enqueue(new MockResponse().setResponseCode(429).setHeader("Retry-After", "2")
                    .setBody("{\"error\":{\"code\":\"RATE_LIMITED\",\"message\":\"Slow down.\"}}"));
        }

        RateLimitException thrown = assertThrowsExactly(RateLimitException.class, () -> client(2).campaigns().get());

        assertEquals("RATE_LIMITED", thrown.rawCode().orElseThrow());
        assertEquals(Duration.ofSeconds(2), thrown.retryAfter().orElseThrow());
        assertEquals(3, apiRequests().size());
        assertEquals(List.of(Duration.ofSeconds(2), Duration.ofSeconds(2)), waits);
    }

    @Test
    void aRetryAfterDateInThePastWaitsNothing() {
        server.enqueue(new MockResponse().setResponseCode(429).setHeader("Retry-After", "Wed, 21 Oct 2015 07:28:00 GMT")
                .setBody("{\"error\":{\"code\":\"RATE_LIMITED\",\"message\":\"Slow down.\"}}"));
        server.enqueueJson(200, CAMPAIGNS);

        client(2).campaigns().get();

        assertEquals(List.of(Duration.ZERO), waits);
    }

    @Test
    void aPlanLimitIsNeverRetried() {
        server.enqueueError(429, "PLAN_LIMIT_EXCEEDED");
        server.enqueueJson(200, CAMPAIGNS);

        assertThrowsExactly(PlanLimitExceededException.class, () -> client(2).campaigns().get());

        assertEquals(1, apiRequests().size());
    }

    @Test
    void noRetriesMeansOneRequest() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, CAMPAIGNS);

        assertThrowsExactly(ServerException.class, () -> client(0).campaigns().get());

        assertEquals(1, apiRequests().size());
    }

    @Test
    void aPutRetries() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, "{\"data\":{}}");

        client(2).products().byExternalId("p1").put(new UpsertProductData());

        assertEquals(List.of("PUT", "PUT"), apiRequests().stream().map(RecordedRequest::getMethod).toList());
    }

    @Test
    void aDeleteRetries() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueue(new MockResponse().setResponseCode(204));

        client(2).products().byExternalId("p1").delete();

        assertEquals(List.of("DELETE", "DELETE"), apiRequests().stream().map(RecordedRequest::getMethod).toList());
    }

    @Test
    void aPatchRetries() {
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, "{\"data\":{}}");

        client(2).products().byExternalId("p1").patch(new UpdateProductData());

        assertEquals(List.of("PATCH", "PATCH"), apiRequests().stream().map(RecordedRequest::getMethod).toList());
    }

    @Test
    void aHeadRetries() throws IOException {
        server.enqueue(new MockResponse().setResponseCode(503));
        server.enqueue(new MockResponse().setResponseCode(200));
        PuntjesOptions options = PuntjesOptions.builder().maxRetries(2).sleeper(waits::add).build();
        OkHttpClient http = new OkHttpClient.Builder().addInterceptor(new RetryInterceptor(options)).build();

        try (Response response = http.newCall(new Request.Builder().url(server.baseUrl() + "/campaigns").head().build())
                .execute()) {
            assertEquals(200, response.code());
        }

        assertEquals(List.of("HEAD", "HEAD"), apiRequests().stream().map(RecordedRequest::getMethod).toList());
    }

    @Test
    void eachRetryAsksForAFreshToken() {
        Map<String, AccessToken> stored = new ConcurrentHashMap<>();
        TokenStore store = new TokenStore() {
            @Override
            public Optional<AccessToken> get(String key) {
                return Optional.ofNullable(stored.get(key));
            }

            @Override
            public void put(String key, AccessToken token) {
                stored.put(key, token);
            }

            @Override
            public void remove(String key, AccessToken rejected) {
                stored.remove(key, rejected);
            }
        };
        server.enqueueError(503, "INTERNAL_ERROR");
        server.enqueueJson(200, CAMPAIGNS);
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(server.baseUrl()).maxRetries(2).tokenStore(store)
                .sleeper(wait -> stored.clear()).build();

        PuntjesClientFactory.create("client-id", "client-secret", options).campaigns().get();

        assertEquals(List.of("Bearer token-1", "Bearer token-2"),
                apiRequests().stream().map(r -> r.getHeader("Authorization")).toList());
    }

    @Test
    @Timeout(6)
    void eachAttemptEndsAtTheTimeoutOfTheOptions() {
        server.enqueue(ApiServer.json(200, CAMPAIGNS).setHeadersDelay(3, TimeUnit.SECONDS));

        assertThrowsExactly(TransportException.class, () -> client(0, Duration.ofSeconds(1)).campaigns().get());
    }

    @Test
    void aGetThatLosesItsConnectionIsSentAgainByOkHttpWithoutAWait() {
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
        server.enqueueJson(200, CAMPAIGNS);

        client(2).campaigns().get();

        assertEquals(2, apiRequests().size());
        assertEquals(List.of(), waits);
    }

    @Test
    void aGetRetriesAfterAReadTimeout() {
        server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.NO_RESPONSE));
        server.enqueueJson(200, CAMPAIGNS);

        client(2, Duration.ofMillis(300)).campaigns().get();

        assertEquals(2, apiRequests().size());
        assertEquals(List.of(Duration.ofMillis(500)), waits);
    }

    @Test
    void aGetRetriesAfterASuccessBodyThatBreaksOff() {
        server.enqueue(new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/json")
                .setBody("{\"data\":{\"data\":[" + "{\"id\":1},".repeat(2000) + "{\"id\":1}]}}")
                .setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY));
        server.enqueueJson(200, CAMPAIGNS);

        client(2).campaigns().get();

        assertEquals(2, apiRequests().size());
        assertEquals(List.of(Duration.ofMillis(500)), waits);
    }

    private List<RecordedRequest> apiRequests() {
        return server.takeRequests().stream().filter(r -> !ApiServer.TOKEN_PATH.equals(r.getPath())).toList();
    }

    private PuntjesClient client(int maxRetries) {
        return client(maxRetries, Duration.ofSeconds(30));
    }

    private PuntjesClient client(int maxRetries, Duration timeout) {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(server.baseUrl()).maxRetries(maxRetries)
                .timeout(timeout).sleeper(waits::add).build();
        return PuntjesClientFactory.create("client-id", "client-secret", options);
    }
}
