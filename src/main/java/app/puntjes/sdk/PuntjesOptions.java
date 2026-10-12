package app.puntjes.sdk;

import app.puntjes.sdk.auth.TokenStore;
import java.time.Duration;
import java.util.Objects;
import java.util.Optional;
import okhttp3.OkHttpClient;

/** The settings of a client built by {@link PuntjesClientFactory}. Start from {@link #builder()}. */
public final class PuntjesOptions {
    /** The production API. */
    public static final String DEFAULT_BASE_URL = "https://puntjes.app/api/v1";

    /** The most retries a call can have; the waits double, so a higher count would wait for hours. */
    public static final int MAX_RETRIES_LIMIT = 10;

    /** Waits between two attempts of a call. Tests replace it so that they do not wait. */
    @FunctionalInterface
    public interface Sleeper {
        /** Blocks for the duration. */
        void sleep(Duration duration) throws InterruptedException;
    }

    private final String baseUrl;
    private final int maxRetries;
    private final Duration retryBaseDelay;
    private final Duration timeout;
    private final TokenStore tokenStore;
    private final OkHttpClient httpClient;
    private final Sleeper sleeper;

    private PuntjesOptions(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.maxRetries = builder.maxRetries;
        this.retryBaseDelay = builder.retryBaseDelay;
        this.timeout = builder.timeout;
        this.tokenStore = builder.tokenStore;
        this.httpClient = builder.httpClient;
        this.sleeper = builder.sleeper;
    }

    /** A builder that starts from the defaults. */
    public static Builder builder() {
        return new Builder();
    }

    /** The API base URL, without a trailing slash. */
    public String baseUrl() {
        return baseUrl;
    }

    /** How many times a failed call is tried again. */
    public int maxRetries() {
        return maxRetries;
    }

    /** The wait before the first retry; each next wait doubles. */
    public Duration retryBaseDelay() {
        return retryBaseDelay;
    }

    /** The connect, read and write timeout of each attempt. */
    public Duration timeout() {
        return timeout;
    }

    /** The store for access tokens, or empty to keep them in memory. */
    public Optional<TokenStore> tokenStore() {
        return Optional.ofNullable(tokenStore);
    }

    /** The client to build on, or empty to start from a new one. */
    public Optional<OkHttpClient> httpClient() {
        return Optional.ofNullable(httpClient);
    }

    /** Waits between retries. */
    public Sleeper sleeper() {
        return sleeper;
    }

    /** Builds {@link PuntjesOptions}. Every setting has a default. */
    public static final class Builder {
        private String baseUrl = DEFAULT_BASE_URL;
        private int maxRetries = 2;
        private Duration retryBaseDelay = Duration.ofMillis(500);
        private Duration timeout = Duration.ofSeconds(30);
        private TokenStore tokenStore;
        private OkHttpClient httpClient;
        private Sleeper sleeper = duration -> Thread.sleep(duration.toMillis());

        private Builder() {
        }

        /** The API base URL; a trailing slash is removed. */
        public Builder baseUrl(String baseUrl) {
            this.baseUrl = Objects.requireNonNull(baseUrl, "baseUrl").replaceAll("/+$", "");
            return this;
        }

        /** How many times a failed call is tried again, from 0 (retries off) to {@link #MAX_RETRIES_LIMIT}. */
        public Builder maxRetries(int maxRetries) {
            if (maxRetries < 0 || maxRetries > MAX_RETRIES_LIMIT) {
                throw new IllegalArgumentException(
                        "maxRetries must be 0 to " + MAX_RETRIES_LIMIT + ", got " + maxRetries);
            }
            this.maxRetries = maxRetries;
            return this;
        }

        /** The wait before the first retry. */
        public Builder retryBaseDelay(Duration retryBaseDelay) {
            this.retryBaseDelay = requireNotNegative(retryBaseDelay, "retryBaseDelay");
            return this;
        }

        /** The connect, read and write timeout of each attempt. */
        public Builder timeout(Duration timeout) {
            this.timeout = requireNotNegative(timeout, "timeout");
            return this;
        }

        /** A store shared between clients, so a token outlives one client. */
        public Builder tokenStore(TokenStore tokenStore) {
            this.tokenStore = Objects.requireNonNull(tokenStore, "tokenStore");
            return this;
        }

        /** A client to build on with {@link OkHttpClient#newBuilder()}. */
        public Builder httpClient(OkHttpClient httpClient) {
            this.httpClient = Objects.requireNonNull(httpClient, "httpClient");
            return this;
        }

        /** Replaces the wait between retries. */
        public Builder sleeper(Sleeper sleeper) {
            this.sleeper = Objects.requireNonNull(sleeper, "sleeper");
            return this;
        }

        /** The options. */
        public PuntjesOptions build() {
            return new PuntjesOptions(this);
        }

        private static Duration requireNotNegative(Duration duration, String name) {
            if (Objects.requireNonNull(duration, name).isNegative()) {
                throw new IllegalArgumentException(name + " must not be negative, got " + duration);
            }
            return duration;
        }
    }
}
