package app.puntjes.sdk.exceptions;

import java.time.Duration;
import java.util.Optional;

/** HTTP 429 with any code but PLAN_LIMIT_EXCEEDED, CARD_SEND_THROTTLED included. Wait {@link #retryAfter()}. */
public final class RateLimitException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    private final Duration retryAfter;

    /** @param retryAfter the wait the Retry-After header asked for, or null when it sent none */
    public RateLimitException(ApiError error, Duration retryAfter) {
        super(error);
        this.retryAfter = retryAfter;
    }

    /** The wait the API asked for, or empty when it sent no Retry-After header. */
    public Optional<Duration> retryAfter() {
        return Optional.ofNullable(retryAfter);
    }
}
