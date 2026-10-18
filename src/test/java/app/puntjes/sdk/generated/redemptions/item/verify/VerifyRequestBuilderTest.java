package app.puntjes.sdk.generated.redemptions.item.verify;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import app.puntjes.sdk.PuntjesClientFactory;
import app.puntjes.sdk.PuntjesOptions;
import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.generated.models.VerifyRedemptionData;
import app.puntjes.sdk.support.ApiServer;
import java.io.IOException;
import okhttp3.mockwebserver.RecordedRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VerifyRequestBuilderTest {
    private ApiServer server;

    @BeforeEach
    void startServer() {
        server = new ApiServer();
        server.respondWith(request -> ApiServer.json(200, "{\"data\":{}}"));
    }

    @AfterEach
    void stopServer() throws IOException {
        server.close();
    }

    @Test
    void postWithoutABodySendsNoContent() {
        verify().post();

        RecordedRequest request = verifyRequest();
        assertEquals("POST", request.getMethod());
        assertEquals(0, request.getBodySize());
        assertNull(request.getHeader("Content-Type"));
    }

    @Test
    void postWithOnlyAConfigurationSendsNoContent() {
        verify().post(config -> config.headers.add("X-Test", "yes"));

        RecordedRequest request = verifyRequest();
        assertEquals("yes", request.getHeader("X-Test"));
        assertEquals(0, request.getBodySize());
        assertNull(request.getHeader("Content-Type"));
    }

    @Test
    void postWithABodySendsItAsJson() {
        VerifyRedemptionData body = new VerifyRedemptionData();
        body.setBranch("north");
        body.setIdempotencyKey("key-1");

        verify().post(body);

        RecordedRequest request = verifyRequest();
        assertEquals("application/json", request.getHeader("Content-Type"));
        assertEquals("{\"branch\":\"north\",\"idempotency_key\":\"key-1\"}", request.getBody().readUtf8());
    }

    private VerifyRequestBuilder verify() {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(server.baseUrl()).sleeper(duration -> { }).build();
        PuntjesClient client = PuntjesClientFactory.create("client-id", "client-secret", options);
        return client.redemptions().byCode("ABC").verify();
    }

    private RecordedRequest verifyRequest() {
        return server.takeRequests().stream()
                .filter(request -> request.getPath().endsWith("/redemptions/ABC/verify"))
                .reduce((first, second) -> { throw new AssertionError("Two verify requests were sent."); })
                .orElseThrow(() -> new AssertionError("No verify request was sent."));
    }
}
