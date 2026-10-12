package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.puntjes.sdk.auth.AccessToken;
import app.puntjes.sdk.auth.InMemoryTokenStore;
import app.puntjes.sdk.auth.TokenStore;
import app.puntjes.sdk.exceptions.AuthenticationException;
import app.puntjes.sdk.exceptions.ServerException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.support.ApiServer;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.HttpUrl;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthenticationTest {
    private static final String ME = "{\"data\":{}}";

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
    void twoCallsShareOneGrantSentAsAFormToTheOrigin() {
        server.enqueueJson(200, ME);
        server.enqueueJson(200, ME);
        PuntjesClient client = client("client-id", "client-secret", options().build());

        client.me().get();
        client.me().get();

        List<RecordedRequest> sent = server.takeRequests();
        List<RecordedRequest> grants = grantsIn(sent);
        assertEquals(1, grants.size());
        assertEquals("POST", grants.get(0).getMethod());
        assertEquals("/oauth/token", grants.get(0).getPath());
        assertTrue(grants.get(0).getHeader("Content-Type").startsWith("application/x-www-form-urlencoded"));
        assertEquals("grant_type=client_credentials&client_id=client-id&client_secret=client-secret",
                grants.get(0).getBody().readUtf8());
        assertEquals(List.of("Bearer token-1", "Bearer token-1"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void aRejectedTokenIsGrantedAgainAndTheCallSentOnceMore() {
        server.enqueueError(401, "UNAUTHENTICATED");
        server.enqueueJson(200, ME);

        client().me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1", "Bearer token-2"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void aSecondRejectionReachesTheCaller() {
        server.enqueueError(401, "UNAUTHENTICATED");
        server.enqueueError(401, "UNAUTHENTICATED");
        server.enqueueJson(200, ME);

        assertThrowsExactly(AuthenticationException.class, () -> client().me().get());

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, grantsIn(sent).size());
        assertEquals(2, apiRequestsIn(sent).size());
    }

    @Test
    void aPublicOperationSendsNoTokenAndStartsNoGrant() {
        server.enqueueJson(200, "{\"data\":{\"status\":\"ok\"}}");

        client().health().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(List.of("/api/v1/health"), sent.stream().map(RecordedRequest::getPath).toList());
        assertNull(sent.get(0).getHeader("Authorization"));
    }

    @Test
    void parallelCallsOnAColdClientShareOneGrant() throws Exception {
        server.enqueueTokenResponse(ApiServer.token("token-1", 3600).setHeadersDelay(200, TimeUnit.MILLISECONDS));
        for (int i = 0; i < 20; i++) {
            server.enqueueJson(200, ME);
        }
        PuntjesClient client = client();

        inParallel(20, i -> client.me().get());

        assertEquals(1, grants().size());
    }

    @Test
    void clientsWithTheSameCredentialsOnOneStoreShareOneGrant() throws Exception {
        server.enqueueTokenResponse(ApiServer.token("token-1", 3600).setHeadersDelay(200, TimeUnit.MILLISECONDS));
        for (int i = 0; i < 10; i++) {
            server.enqueueJson(200, ME);
        }
        InMemoryTokenStore store = new InMemoryTokenStore();
        List<PuntjesClient> clients = List.of(
                client("client-id", "client-secret", options().tokenStore(store).build()),
                client("client-id", "client-secret", options().tokenStore(store).build()));

        inParallel(10, i -> clients.get(i % 2).me().get());

        assertEquals(1, grants().size());
    }

    @Test
    void shopsThatShareAStoreKeepTheirOwnToken() {
        for (int i = 0; i < 4; i++) {
            server.enqueueJson(200, ME);
        }
        InMemoryTokenStore store = new InMemoryTokenStore();
        PuntjesClient shopA = client("shop-a", "secret-a", options().tokenStore(store).build());
        PuntjesClient shopB = client("shop-b", "secret-b", options().tokenStore(store).build());

        shopA.me().get();
        shopB.me().get();
        shopA.me().get();
        shopB.me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(List.of(
                "grant_type=client_credentials&client_id=shop-a&client_secret=secret-a",
                "grant_type=client_credentials&client_id=shop-b&client_secret=secret-b"),
                grantsIn(sent).stream().map(r -> r.getBody().readUtf8()).toList());
        assertEquals(List.of("Bearer token-1", "Bearer token-2", "Bearer token-1", "Bearer token-2"),
                authorizations(apiRequestsIn(sent)));
    }

    @Test
    void theStoreKeyIsTheSha256OfTheOriginAndTheCredentials() throws NoSuchAlgorithmException {
        server.enqueueJson(200, ME);
        List<String> keys = new CopyOnWriteArrayList<>();
        InMemoryTokenStore inner = new InMemoryTokenStore();
        TokenStore recording = new TokenStore() {
            @Override
            public Optional<AccessToken> get(String key) {
                keys.add(key);
                return inner.get(key);
            }

            @Override
            public void put(String key, AccessToken token) {
                keys.add(key);
                inner.put(key, token);
            }

            @Override
            public void remove(String key, AccessToken rejected) {
                keys.add(key);
                inner.remove(key, rejected);
            }
        };

        client("client-id", "client-secret", options().tokenStore(recording).build()).me().get();

        HttpUrl base = HttpUrl.get(server.baseUrl());
        String origin = base.scheme() + "://" + base.host() + ":" + base.port();
        String expected = "puntjes:token:" + HexFormat.of().formatHex(MessageDigest.getInstance("SHA-256")
                .digest((origin + "|client-id|client-secret").getBytes(StandardCharsets.UTF_8)));
        assertTrue(keys.size() >= 2);
        assertEquals(List.of(expected), keys.stream().distinct().toList());
    }

    @Test
    void aStoredTokenIsUsedWhileItHasMoreThanThirtySecondsLeft() {
        server.enqueueJson(200, ME);
        TokenStore store = storeHolding(new AccessToken("stored", Instant.now().plusSeconds(40)));

        client("client-id", "client-secret", options().tokenStore(store).build()).me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(0, grantsIn(sent).size());
        assertEquals(List.of("Bearer stored"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void aStoredTokenTwentySecondsFromExpiryIsReplaced() {
        server.enqueueJson(200, ME);
        TokenStore store = storeHolding(new AccessToken("stale", Instant.now().plusSeconds(20)));

        client("client-id", "client-secret", options().tokenStore(store).build()).me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(1, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void anExpiredStoredTokenIsReplaced() {
        server.enqueueJson(200, ME);
        TokenStore store = storeHolding(new AccessToken("expired", Instant.now().minusSeconds(60)));

        client("client-id", "client-secret", options().tokenStore(store).build()).me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(1, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1"), authorizations(apiRequestsIn(sent)));
        assertEquals("token-1", store.get("any").orElseThrow().value());
    }

    @Test
    void aShortLivedTokenIsReplacedWhenItsOwnLifetimeEnds() {
        server.enqueueTokenResponse(ApiServer.token("short", 10));
        server.enqueueJson(200, ME);
        server.enqueueJson(200, ME);
        PuntjesClient client = client();

        client.me().get();
        client.me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, grantsIn(sent).size());
        assertEquals(List.of("Bearer short", "Bearer token-1"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void rejectedCredentialsThrowAnAuthenticationException() {
        server.enqueueTokenResponse(ApiServer.json(401,
                "{\"error\":\"invalid_client\",\"error_description\":\"Client authentication failed\"}"));
        server.enqueueJson(200, ME);

        AuthenticationException error = assertThrowsExactly(AuthenticationException.class, () -> client().me().get());

        assertEquals("Client authentication failed", error.getMessage());
        assertEquals(Optional.of("invalid_client"), error.rawCode());
        assertEquals(OptionalInt.of(401), error.status());
        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(1, grantsIn(sent).size());
        assertEquals(0, apiRequestsIn(sent).size());
    }

    @Test
    void aTokenEndpointHiccupIsRetriedLikeAGet() {
        server.enqueueTokenResponse(ApiServer.json(503,
                "{\"error\":{\"code\":\"INTERNAL_ERROR\",\"message\":\"Down.\"}}"));
        server.enqueueJson(200, ME);

        client().me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void aTokenEndpointNetworkFailureIsRetried() {
        server.enqueueTokenResponse(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
        server.enqueueJson(200, ME);

        client().me().get();

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1"), authorizations(apiRequestsIn(sent)));
    }

    @Test
    void aTokenEndpointThatStaysDownIsAServerErrorAfterTheRetries() {
        for (int i = 0; i < 3; i++) {
            server.enqueueTokenResponse(ApiServer.json(503,
                    "{\"error\":{\"code\":\"INTERNAL_ERROR\",\"message\":\"Down.\"}}"));
        }
        server.enqueueJson(200, ME);

        assertThrowsExactly(ServerException.class, () -> client().me().get());

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(3, grantsIn(sent).size());
        assertEquals(0, apiRequestsIn(sent).size());
    }

    @Test
    void parallelRejectionsShareOneNewGrant() throws Exception {
        TokenStore store = storeHolding(new AccessToken("old", Instant.now().plusSeconds(3600)));
        CountDownLatch bothRejected = new CountDownLatch(2);
        AtomicInteger rejections = new AtomicInteger();
        server.respondWith(request -> {
            if (!"Bearer old".equals(request.getHeader("Authorization"))) {
                return ApiServer.json(200, ME);
            }
            int arrival = rejections.incrementAndGet();
            bothRejected.countDown();
            awaitQuietly(bothRejected);
            MockResponse rejected = ApiServer.json(401,
                    "{\"error\":{\"code\":\"UNAUTHENTICATED\",\"message\":\"No.\"}}");
            return arrival == 1 ? rejected : rejected.setHeadersDelay(500, TimeUnit.MILLISECONDS);
        });
        PuntjesClient client = client("client-id", "client-secret", options().tokenStore(store).build());

        inParallel(2, i -> client.me().get());

        List<RecordedRequest> sent = server.takeRequests();
        assertEquals(2, rejections.get());
        assertEquals(1, grantsIn(sent).size());
        assertEquals(List.of("Bearer token-1", "Bearer token-1"),
                authorizations(apiRequestsIn(sent)).stream().filter(a -> !a.equals("Bearer old")).toList());
    }

    private interface Call {
        void run(int index) throws Exception;
    }

    private static void inParallel(int calls, Call call) throws Exception {
        ExecutorService pool = Executors.newFixedThreadPool(calls);
        CountDownLatch start = new CountDownLatch(1);
        try {
            List<Future<?>> done = new ArrayList<>();
            for (int i = 0; i < calls; i++) {
                int index = i;
                done.add(pool.submit(() -> {
                    start.await();
                    call.run(index);
                    return null;
                }));
            }
            start.countDown();
            for (Future<?> future : done) {
                future.get(10, TimeUnit.SECONDS);
            }
        } finally {
            pool.shutdownNow();
        }
    }

    private static void awaitQuietly(CountDownLatch latch) {
        try {
            latch.await(5, TimeUnit.SECONDS);
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
        }
    }

    private static TokenStore storeHolding(AccessToken token) {
        InMemoryTokenStore inner = new InMemoryTokenStore();
        inner.put("any", token);
        return new TokenStore() {
            @Override
            public Optional<AccessToken> get(String key) {
                return inner.get("any");
            }

            @Override
            public void put(String key, AccessToken token) {
                inner.put("any", token);
            }

            @Override
            public void remove(String key, AccessToken rejected) {
                inner.remove("any", rejected);
            }
        };
    }

    private List<RecordedRequest> grants() {
        return grantsIn(server.takeRequests());
    }

    private static List<RecordedRequest> grantsIn(List<RecordedRequest> sent) {
        return sent.stream().filter(r -> ApiServer.TOKEN_PATH.equals(r.getPath())).toList();
    }

    private static List<RecordedRequest> apiRequestsIn(List<RecordedRequest> sent) {
        return sent.stream().filter(r -> !ApiServer.TOKEN_PATH.equals(r.getPath())).toList();
    }

    private static List<String> authorizations(List<RecordedRequest> requests) {
        return requests.stream().map(r -> r.getHeader("Authorization")).toList();
    }

    private PuntjesOptions.Builder options() {
        return PuntjesOptions.builder().baseUrl(server.baseUrl()).sleeper(wait -> { });
    }

    private PuntjesClient client() {
        return client("client-id", "client-secret", options().build());
    }

    private PuntjesClient client(String clientId, String clientSecret, PuntjesOptions options) {
        return PuntjesClientFactory.create(clientId, clientSecret, options);
    }
}
