package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import app.puntjes.sdk.exceptions.AuthenticationException;
import app.puntjes.sdk.exceptions.ConflictException;
import app.puntjes.sdk.exceptions.ForbiddenException;
import app.puntjes.sdk.exceptions.NotFoundException;
import app.puntjes.sdk.exceptions.PlanLimitExceededException;
import app.puntjes.sdk.exceptions.PuntjesException;
import app.puntjes.sdk.exceptions.RateLimitException;
import app.puntjes.sdk.exceptions.ServerException;
import app.puntjes.sdk.exceptions.TransportException;
import app.puntjes.sdk.exceptions.ValidationException;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.generated.errors.ErrorCode;
import app.puntjes.sdk.support.ApiServer;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Stream;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.RecordedRequest;
import okhttp3.mockwebserver.SocketPolicy;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ErrorMappingTest {
    private static final int ATTEMPTS = 3;

    private ApiServer server;

    @BeforeEach
    void startServer() {
        server = new ApiServer();
        server.enqueueToken();
    }

    @AfterEach
    void stopServer() throws IOException {
        server.close();
    }

    static Stream<Arguments> families() {
        return Stream.of(
                Arguments.of(401, ErrorCode.UNAUTHENTICATED, AuthenticationException.class),
                Arguments.of(403, ErrorCode.FORBIDDEN, ForbiddenException.class),
                Arguments.of(404, ErrorCode.CUSTOMER_NOT_FOUND, NotFoundException.class),
                Arguments.of(409, ErrorCode.IDENTIFIER_DUPLICATE, ConflictException.class),
                Arguments.of(422, ErrorCode.VALIDATION_ERROR, ValidationException.class),
                Arguments.of(422, ErrorCode.INSUFFICIENT_BALANCE, PuntjesException.class),
                Arguments.of(429, ErrorCode.RATE_LIMITED, RateLimitException.class),
                Arguments.of(429, ErrorCode.PLAN_LIMIT_EXCEEDED, PlanLimitExceededException.class),
                Arguments.of(500, ErrorCode.INTERNAL_ERROR, ServerException.class),
                Arguments.of(405, ErrorCode.METHOD_NOT_ALLOWED, PuntjesException.class));
    }

    @ParameterizedTest
    @MethodSource("families")
    void eachStatusAndCodeThrowsItsFamily(int status, ErrorCode code, Class<? extends PuntjesException> family) {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueueError(status, code.wire());
        }

        PuntjesException error = assertThrowsExactly(family, () -> client().campaigns().get());

        assertEquals(Optional.of(code), error.errorCode());
        assertEquals(Optional.of(code.wire()), error.rawCode());
        assertEquals(OptionalInt.of(status), error.status());
        assertEquals(Optional.of("req-1"), error.requestId());
        assertEquals("Something about " + code.wire() + ".", error.getMessage());
    }

    @Test
    void aCodeTheEnumDoesNotKnowKeepsTheRawCode() {
        server.enqueueError(404, "SOMETHING_NEW");

        NotFoundException error = assertThrowsExactly(NotFoundException.class, () -> client().campaigns().get());

        assertEquals(Optional.empty(), error.errorCode());
        assertEquals(Optional.of("SOMETHING_NEW"), error.rawCode());
    }

    @Test
    void theRequestIdInTheEnvelopeWinsOverTheHeader() {
        server.enqueue(new MockResponse().setResponseCode(404).setHeader("X-Request-ID", "req-header")
                .setBody("""
                        {"error":{"code":"CUSTOMER_NOT_FOUND","message":"No.","request_id":"req-body"}}"""));

        NotFoundException error = assertThrowsExactly(NotFoundException.class, () -> client().campaigns().get());

        assertEquals(Optional.of("req-body"), error.requestId());
    }

    @Test
    void theRequestIdFallsBackToTheResponseHeader() {
        server.enqueue(new MockResponse().setResponseCode(404).setHeader("X-Request-ID", "req-header")
                .setBody("{\"error\":{\"code\":\"CUSTOMER_NOT_FOUND\",\"message\":\"No.\"}}"));

        NotFoundException error = assertThrowsExactly(NotFoundException.class, () -> client().campaigns().get());

        assertEquals(Optional.of("req-header"), error.requestId());
    }

    @Test
    void aNonJsonServerErrorIsAServerExceptionWithNoCode() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setResponseCode(502).setBody("<html>bad gateway</html>"));
        }

        ServerException error = assertThrowsExactly(ServerException.class, () -> client().campaigns().get());

        assertEquals(OptionalInt.of(502), error.status());
        assertEquals(Optional.empty(), error.errorCode());
        assertEquals(Optional.empty(), error.rawCode());
        assertEquals("The Puntjes API returned HTTP 502.", error.getMessage());
    }

    @Test
    void jsonWithoutAnErrorCodeIsAServerExceptionWithNoCode() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueueJson(500, "{\"message\":\"no envelope\"}");
        }

        ServerException error = assertThrowsExactly(ServerException.class, () -> client().campaigns().get());

        assertEquals(Optional.empty(), error.errorCode());
        assertEquals(Optional.empty(), error.rawCode());
    }

    @Test
    void aNonJsonClientErrorThrowsTheFamilyOfItsStatus() {
        server.enqueue(new MockResponse().setResponseCode(404).setBody("<html>not here</html>"));

        NotFoundException error = assertThrowsExactly(NotFoundException.class, () -> client().campaigns().get());

        assertEquals(OptionalInt.of(404), error.status());
        assertEquals(Optional.empty(), error.errorCode());
        assertEquals(Optional.empty(), error.rawCode());
    }

    @Test
    void anErrorThatIsTextIsTheFamilyOfItsStatus() {
        server.enqueueJson(409, "{\"error\":\"text\"}");

        ConflictException error = assertThrowsExactly(ConflictException.class, () -> client().campaigns().get());

        assertEquals(Optional.empty(), error.rawCode());
        assertEquals("The Puntjes API returned HTTP 409.", error.getMessage());
    }

    @Test
    void aCodeThatIsNotTextIsNoCode() {
        server.enqueueJson(403, "{\"error\":{\"code\":123,\"message\":\"No.\"}}");

        ForbiddenException error = assertThrowsExactly(ForbiddenException.class, () -> client().campaigns().get());

        assertEquals(Optional.empty(), error.rawCode());
        assertEquals(Optional.empty(), error.errorCode());
    }

    @Test
    void aValidationErrorCarriesTheMessagesOfEachField() {
        server.enqueueJson(422, """
                {"error":{"code":"VALIDATION_ERROR","message":"The given data was invalid.","status":422,
                "request_id":"req-1","details":{"email":["The email is invalid.","The email is taken."],
                "name":["The name is required."]}}}""");

        ValidationException error = assertThrowsExactly(ValidationException.class, () -> client().campaigns().get());

        assertEquals(Map.of("email", List.of("The email is invalid.", "The email is taken."),
                "name", List.of("The name is required.")), error.details());
        assertEquals(List.of("The email is invalid.", "The email is taken."), error.errorsFor("email"));
        assertEquals(List.of(), error.errorsFor("phone"));
        assertThrows(UnsupportedOperationException.class, () -> error.details().put("phone", List.of()));
    }

    @ParameterizedTest
    @ValueSource(strings = {
        "",
        ",\"details\":null",
        ",\"details\":\"bad\"",
        ",\"details\":[\"bad\"]",
        ",\"details\":{\"email\":\"not a list\",\"name\":[1,{\"a\":2}]}"
    })
    void aMissingOrMalformedDetailsBlockGivesNoFieldErrors(String details) {
        server.enqueueJson(422, "{\"error\":{\"code\":\"VALIDATION_ERROR\",\"message\":\"Invalid.\"" + details + "}}");

        ValidationException error = assertThrowsExactly(ValidationException.class, () -> client().campaigns().get());

        assertEquals(Map.of(), error.details());
        assertEquals(List.of(), error.errorsFor("email"));
    }

    @Test
    void aRateLimitCarriesTheWaitFromRetryAfter() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setResponseCode(429).setHeader("Retry-After", "3")
                    .setBody("{\"error\":{\"code\":\"RATE_LIMITED\",\"message\":\"Slow down.\"}}"));
        }

        RateLimitException error = assertThrowsExactly(RateLimitException.class, () -> client().campaigns().get());

        assertEquals(Optional.of(Duration.ofSeconds(3)), error.retryAfter());
    }

    @Test
    void aRetryAfterDateInThePastWaitsNothing() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setResponseCode(429)
                    .setHeader("Retry-After", "Wed, 21 Oct 2015 07:28:00 GMT")
                    .setBody("{\"error\":{\"code\":\"RATE_LIMITED\",\"message\":\"Slow down.\"}}"));
        }

        RateLimitException error = assertThrowsExactly(RateLimitException.class, () -> client().campaigns().get());

        assertEquals(Optional.of(Duration.ZERO), error.retryAfter());
    }

    @Test
    void aClosedSocketIsATransportException() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AFTER_REQUEST));
        }

        TransportException error = assertThrowsExactly(TransportException.class, () -> client().campaigns().get());

        assertInstanceOf(IOException.class, error.getCause());
        assertTrue(error.status().isEmpty());
        assertEquals(List.of("/api/v1/campaigns"), apiPaths().stream().distinct().toList());
    }

    @Test
    void anErrorBodyThatBreaksOffKeepsTheStatus() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setResponseCode(500).setHeader("Content-Type", "application/json")
                    .setBody("{\"error\":{\"message\":\"" + "x".repeat(20000) + "\"}}")
                    .setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY));
        }

        ServerException error = assertThrowsExactly(ServerException.class, () -> client().campaigns().get());

        assertEquals(OptionalInt.of(500), error.status());
        assertEquals(Optional.empty(), error.rawCode());
    }

    @Test
    void aBodyThatBreaksOffIsATransportException() {
        for (int i = 0; i < ATTEMPTS; i++) {
            server.enqueue(new MockResponse().setResponseCode(200).setHeader("Content-Type", "application/json")
                    .setBody("{\"data\":{\"data\":[" + "{\"id\":1},".repeat(2000) + "{\"id\":1}]}}")
                    .setSocketPolicy(SocketPolicy.DISCONNECT_DURING_RESPONSE_BODY));
        }

        assertThrowsExactly(TransportException.class, () -> client().campaigns().get());
    }

    @Test
    void aSuccessfulResponseReachesTheGeneratedModel() {
        server.enqueueJson(200, "{\"data\":{\"data\":[],\"meta\":{\"current_page\":1}}}");

        var campaigns = client().campaigns().get();

        assertEquals(0, campaigns.getData().getData().size());
        assertEquals(List.of("/api/v1/campaigns"), apiPaths());
    }

    private List<String> apiPaths() {
        return server.takeRequests().stream().map(RecordedRequest::getPath)
                .filter(path -> !ApiServer.TOKEN_PATH.equals(path)).toList();
    }

    private PuntjesClient client() {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(server.baseUrl()).sleeper(duration -> { }).build();
        return PuntjesClientFactory.create("client-id", "client-secret", options);
    }
}
