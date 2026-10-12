package app.puntjes.sdk.http;

import app.puntjes.sdk.PuntjesOptions;
import app.puntjes.sdk.generated.errors.ErrorCode;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Optional;
import java.util.Set;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.Buffer;

/**
 * Sends a call again after a network failure, a 5xx or a {@code RATE_LIMITED} answer, but only when sending it twice is
 * safe: a read, a write that replaces, or a POST that carries an {@code idempotency_key}. The response body is read here,
 * so a successful body that breaks off is a network failure too.
 */
public final class RetryInterceptor implements Interceptor {
    private static final Set<String> REPEATABLE_METHODS = Set.of("GET", "HEAD", "PUT", "PATCH", "DELETE");
    private static final String IDEMPOTENCY_KEY = "idempotency_key";

    private final int maxRetries;
    private final Duration baseDelay;
    private final PuntjesOptions.Sleeper sleeper;

    /** Retries as the options say. */
    public RetryInterceptor(PuntjesOptions options) {
        this.maxRetries = options.maxRetries();
        this.baseDelay = options.retryBaseDelay();
        this.sleeper = options.sleeper();
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (request.method().equals("POST")) {
            request = withBodyRead(request);
        }
        int retries = isSafeToRepeat(request) ? maxRetries : 0;
        for (int attempt = 0; ; attempt++) {
            Response response;
            try {
                response = buffered(chain.proceed(request));
            } catch (IOException networkFailure) {
                if (attempt >= retries) {
                    throw networkFailure;
                }
                waitFor(baseDelay.multipliedBy(1L << attempt));
                continue;
            }
            if (attempt >= retries || !isTransient(response)) {
                return response;
            }
            Duration wait = RetryAfter.of(response, Instant.now()).orElse(baseDelay.multipliedBy(1L << attempt));
            response.close();
            waitFor(wait);
        }
    }

    private static Request withBodyRead(Request request) throws IOException {
        RequestBody body = request.body();
        if (body == null) {
            return request;
        }
        Buffer bytes = new Buffer();
        body.writeTo(bytes);
        return request.newBuilder().method("POST", RequestBody.create(bytes.readByteArray(), body.contentType())).build();
    }

    private static boolean isSafeToRepeat(Request request) throws IOException {
        return REPEATABLE_METHODS.contains(request.method())
                || request.method().equals("POST") && carriesIdempotencyKey(request.body());
    }

    private static boolean carriesIdempotencyKey(RequestBody body) throws IOException {
        if (body == null) {
            return false;
        }
        Buffer bytes = new Buffer();
        body.writeTo(bytes);
        try {
            return JsonParser.parseString(bytes.readUtf8()) instanceof JsonObject root
                    && !text(root.get(IDEMPOTENCY_KEY)).isEmpty();
        } catch (JsonParseException notJson) {
            return false;
        }
    }

    private static Response buffered(Response response) throws IOException {
        ResponseBody body = response.body();
        if (body == null || !response.isSuccessful()) {
            return response;
        }
        try (body) {
            return response.newBuilder().body(ResponseBody.create(body.bytes(), body.contentType())).build();
        }
    }

    private static boolean isTransient(Response response) throws IOException {
        return response.code() >= 500
                || response.code() == 429 && ErrorCode.RATE_LIMITED.wire().equals(errorCode(response));
    }

    private static String errorCode(Response response) throws IOException {
        if (response.body() == null) {
            return "";
        }
        try {
            return JsonParser.parseString(response.peekBody(Long.MAX_VALUE).string()) instanceof JsonObject root
                    && root.get("error") instanceof JsonObject error ? text(error.get("code")) : "";
        } catch (JsonParseException | IOException unreadable) {
            return "";
        }
    }

    private static String text(JsonElement value) {
        return value != null && value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()
                ? value.getAsString() : "";
    }

    private void waitFor(Duration wait) throws IOException {
        try {
            sleeper.sleep(wait);
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("Interrupted while waiting to try the call again");
        }
    }
}
