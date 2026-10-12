package app.puntjes.sdk.http;

import app.puntjes.sdk.exceptions.ApiError;
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
import app.puntjes.sdk.generated.errors.ErrorCode;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.time.Instant;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Turns a response that is not a success into the exception of its family, and a network failure into a
 * {@link TransportException}. A success body is read here, so a body that breaks off is a transport failure too.
 */
public final class ErrorInterceptor implements Interceptor {
    private static final String REQUEST_ID_HEADER = "X-Request-ID";

    @Override
    public Response intercept(Chain chain) {
        try {
            Response response = chain.proceed(chain.request());
            if (!response.isSuccessful()) {
                throw toException(response);
            }
            return buffered(response);
        } catch (IOException e) {
            throw new TransportException("The Puntjes API could not be reached: " + e.getMessage(), e);
        }
    }

    private static Response buffered(Response response) throws IOException {
        ResponseBody body = response.body();
        if (body == null) {
            return response;
        }
        try (body) {
            return response.newBuilder().body(ResponseBody.create(body.bytes(), body.contentType())).build();
        }
    }

    private static PuntjesException toException(Response response) throws IOException {
        try (response) {
            ApiError error = readError(response);
            return switch (error.status()) {
                case 401 -> new AuthenticationException(error);
                case 403 -> new ForbiddenException(error);
                case 404 -> new NotFoundException(error);
                case 409 -> new ConflictException(error);
                case 422 -> hasCode(error, ErrorCode.VALIDATION_ERROR)
                        ? new ValidationException(error) : new PuntjesException(error);
                case 429 -> hasCode(error, ErrorCode.PLAN_LIMIT_EXCEEDED)
                        ? new PlanLimitExceededException(error)
                        : new RateLimitException(error, RetryAfter.of(response, Instant.now()).orElse(null));
                default -> error.status() >= 500 ? new ServerException(error) : new PuntjesException(error);
            };
        }
    }

    private static ApiError readError(Response response) throws IOException {
        ResponseBody body = response.body();
        JsonObject envelope = envelope(body == null ? "" : body.string());
        String message = text(envelope, "message");
        String requestId = text(envelope, "request_id");
        return new ApiError(
                response.code(),
                text(envelope, "code"),
                message != null ? message : "The Puntjes API returned HTTP " + response.code() + ".",
                requestId != null ? requestId : response.header(REQUEST_ID_HEADER));
    }

    private static JsonObject envelope(String body) {
        JsonElement root;
        try {
            root = JsonParser.parseString(body);
        } catch (JsonParseException notJson) {
            return new JsonObject();
        }
        return root.isJsonObject() && root.getAsJsonObject().get("error") instanceof JsonObject error
                ? error : new JsonObject();
    }

    private static String text(JsonObject object, String name) {
        JsonElement value = object.get(name);
        return value != null && value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()
                ? value.getAsString() : null;
    }

    private static boolean hasCode(ApiError error, ErrorCode code) {
        return code.wire().equals(error.code());
    }
}
