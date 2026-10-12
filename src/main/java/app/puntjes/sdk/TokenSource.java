package app.puntjes.sdk;

import app.puntjes.sdk.auth.AccessToken;
import app.puntjes.sdk.auth.TokenStore;
import app.puntjes.sdk.exceptions.ApiError;
import app.puntjes.sdk.exceptions.AuthenticationException;
import app.puntjes.sdk.exceptions.TransportException;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.HexFormat;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.locks.ReentrantLock;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

final class TokenSource {
    private static final Duration LEEWAY = Duration.ofSeconds(30);
    private static final long DEFAULT_LIFETIME_SECONDS = 3600;
    private static final ConcurrentMap<String, ReentrantLock> GRANT_LOCKS = new ConcurrentHashMap<>();

    private final String clientId;
    private final String clientSecret;
    private final HttpUrl tokenUrl;
    private final String key;
    private final TokenStore store;
    private final OkHttpClient grants;
    private final ReentrantLock grantLock;

    TokenSource(String clientId, String clientSecret, HttpUrl baseUrl, TokenStore store, OkHttpClient grants) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
        this.tokenUrl = baseUrl.newBuilder().encodedPath("/oauth/token").query(null).fragment(null).build();
        this.key = keyFor(baseUrl, clientId, clientSecret);
        this.store = store;
        this.grants = grants;
        this.grantLock = GRANT_LOCKS.computeIfAbsent(key, k -> new ReentrantLock());
    }

    AccessToken get() throws IOException {
        Optional<AccessToken> stored = usable(store.get(key));
        if (stored.isPresent()) {
            return stored.get();
        }
        lock();
        try {
            Optional<AccessToken> granted = usable(store.get(key));
            if (granted.isPresent()) {
                return granted.get();
            }
            AccessToken fresh = grant();
            store.put(key, fresh);
            return fresh;
        } finally {
            grantLock.unlock();
        }
    }

    void reject(AccessToken rejected) throws IOException {
        lock();
        try {
            Optional<AccessToken> stored = store.get(key);
            if (stored.isPresent() && stored.get().value().equals(rejected.value())) {
                store.remove(key, stored.get());
            }
        } finally {
            grantLock.unlock();
        }
    }

    private void lock() throws InterruptedIOException {
        try {
            grantLock.lockInterruptibly();
        } catch (InterruptedException interrupted) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException("Interrupted while waiting for the Puntjes token grant");
        }
    }

    private static Optional<AccessToken> usable(Optional<AccessToken> token) {
        return token.filter(t -> t.expiresAt().minus(LEEWAY).isAfter(Instant.now()));
    }

    private AccessToken grant() throws IOException {
        Request request = new Request.Builder()
                .url(tokenUrl)
                .header("Accept", "application/json")
                .tag(TokenSource.class, this)
                .post(new FormBody.Builder()
                        .add("grant_type", "client_credentials")
                        .add("client_id", clientId)
                        .add("client_secret", clientSecret)
                        .build())
                .build();
        Instant issuedAt = Instant.now();
        Response response;
        try {
            response = grants.newCall(request).execute();
        } catch (IOException e) {
            throw new TransportException("The Puntjes token endpoint could not be reached: " + e.getMessage(), e);
        }
        if (response.code() == 400 || response.code() == 401) {
            throw rejected(response);
        }
        if (!response.isSuccessful()) {
            throw ErrorInterceptor.toException(response);
        }
        try (response) {
            return parse(json(response), issuedAt);
        }
    }

    private static AuthenticationException rejected(Response response) {
        try (response) {
            JsonObject body = json(response);
            String description = text(body, "error_description");
            return new AuthenticationException(new ApiError(response.code(), text(body, "error"),
                    description != null ? description : "The Puntjes API refused the client credentials.",
                    response.header("X-Request-ID"), Map.of()));
        }
    }

    private static JsonObject json(Response response) {
        try {
            return JsonParser.parseString(response.body() == null ? "" : response.body().string())
                    instanceof JsonObject object ? object : new JsonObject();
        } catch (JsonParseException | IOException unreadable) {
            return new JsonObject();
        }
    }

    private static String text(JsonObject object, String name) {
        JsonElement value = object.get(name);
        return value != null && value.isJsonPrimitive() && value.getAsJsonPrimitive().isString()
                ? value.getAsString() : null;
    }

    private static AccessToken parse(JsonObject root, Instant issuedAt) {
        String value = text(root, "access_token");
        if (value == null || value.isEmpty()) {
            throw new TransportException("The Puntjes token endpoint returned no access_token.", null);
        }
        JsonElement expiresIn = root.get("expires_in");
        long lifetime = expiresIn != null && expiresIn.isJsonPrimitive() && expiresIn.getAsJsonPrimitive().isNumber()
                ? expiresIn.getAsLong() : DEFAULT_LIFETIME_SECONDS;
        return new AccessToken(value, issuedAt.plusSeconds(lifetime).truncatedTo(ChronoUnit.SECONDS));
    }

    private static String keyFor(HttpUrl baseUrl, String clientId, String clientSecret) {
        String origin = baseUrl.scheme() + "://" + baseUrl.host() + ":" + baseUrl.port();
        try {
            byte[] hash = MessageDigest.getInstance("SHA-256")
                    .digest((origin + "|" + clientId + "|" + clientSecret).getBytes(StandardCharsets.UTF_8));
            return "puntjes:token:" + HexFormat.of().formatHex(hash);
        } catch (NoSuchAlgorithmException missing) {
            throw new IllegalStateException("Every Java platform must support SHA-256", missing);
        }
    }
}
