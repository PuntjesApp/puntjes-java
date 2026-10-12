package app.puntjes.sdk.support;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

/** A fake Puntjes API: token grants and API calls answer from two queues, so a grant never eats an API response. */
public final class ApiServer implements AutoCloseable {
    public static final String TOKEN_PATH = "/oauth/token";

    private final MockWebServer server = new MockWebServer();
    private final Queue<MockResponse> tokens = new ConcurrentLinkedQueue<>();
    private final Queue<MockResponse> responses = new ConcurrentLinkedQueue<>();
    private final Queue<RecordedRequest> requests = new ConcurrentLinkedQueue<>();

    public ApiServer() {
        server.setDispatcher(new Dispatcher() {
            @Override
            public MockResponse dispatch(RecordedRequest request) {
                requests.add(request);
                Queue<MockResponse> queue = TOKEN_PATH.equals(request.getPath()) ? tokens : responses;
                MockResponse next = queue.poll();
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
        return server.url("/api/v1").newBuilder().host("127.0.0.1").build().toString();
    }

    public void enqueueToken() {
        tokens.add(json(200, "{\"access_token\":\"token-1\",\"token_type\":\"Bearer\",\"expires_in\":3600}"));
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

    private static MockResponse json(int status, String body) {
        return new MockResponse().setResponseCode(status).setHeader("Content-Type", "application/json").setBody(body);
    }
}
