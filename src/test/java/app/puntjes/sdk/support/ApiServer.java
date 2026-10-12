package app.puntjes.sdk.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/**
 * A fake Puntjes API: token grants and API calls answer from two queues, so a grant never eats an API response. A grant
 * with nothing enqueued answers a fresh token, {@code token-1}, {@code token-2} and so on.
 */
public final class ApiServer implements AutoCloseable {
    public static final String TOKEN_PATH = "/oauth/token";

    private final MockWebServer server = new MockWebServer();
    private final Queue<MockResponse> tokens = new ConcurrentLinkedQueue<>();
    private final Queue<MockResponse> responses = new ConcurrentLinkedQueue<>();
    private final Queue<RecordedRequest> requests = new ConcurrentLinkedQueue<>();
    private final AtomicInteger issuedTokens = new AtomicInteger();
    private volatile Function<RecordedRequest, MockResponse> responder;

    public ApiServer() {
        server.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) {
                requests.add(request);
                if (TOKEN_PATH.equals(request.getPath())) {
                    MockResponse next = tokens.poll();
                    return next != null ? next : token("token-" + issuedTokens.incrementAndGet(), 3600);
                }
                if (responder != null) {
                    return responder.apply(request);
                }
                MockResponse next = responses.poll();
                return next != null ? next : new MockResponse().setResponseCode(599).setBody("nothing enqueued");
            }
        });
        try {
            server.start();
        } catch (IOException e) {
            throw new IllegalStateException("The fake API could not start", e);
        }
    }

    public String baseUrl() {
        return server.url("/api/v1").toString();
    }

    public static MockResponse token(String value, int expiresIn) {
        return json(200, "{\"access_token\":\"%s\",\"token_type\":\"Bearer\",\"expires_in\":%d}"
                .formatted(value, expiresIn));
    }

    public void enqueueTokenResponse(MockResponse response) {
        tokens.add(response);
    }

    public void respondWith(Function<RecordedRequest, MockResponse> responder) {
        this.responder = responder;
    }

    public void enqueueJson(int status, String body) {
        enqueue(json(status, body));
    }

    public void enqueueError(int status, String code) {
        enqueueJson(status, """
                {"error":{"code":"%s","message":"Something about %s.","status":%d,"request_id":"req-1"}}"""
                .formatted(code, code, status));
    }

    public void enqueue(MockResponse response) {
        responses.add(response);
    }

    public List<RecordedRequest> takeRequests() {
        List<RecordedRequest> taken = new ArrayList<>();
        for (RecordedRequest request = requests.poll(); request != null; request = requests.poll()) {
            taken.add(request);
        }
        return taken;
    }

    @Override
    public void close() throws IOException {
        server.shutdown();
    }

    public static MockResponse json(int status, String body) {
        return new MockResponse().setResponseCode(status).setHeader("Content-Type", "application/json").setBody(body);
    }
}
