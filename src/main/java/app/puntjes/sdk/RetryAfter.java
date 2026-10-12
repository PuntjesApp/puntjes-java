package app.puntjes.sdk;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import okhttp3.Response;

final class RetryAfter {
    private static final String HEADER = "Retry-After";

    private RetryAfter() {
    }

    static Optional<Duration> of(Response response, Instant now) {
        String value = response.header(HEADER);
        if (value == null) {
            return Optional.empty();
        }
        if (value.trim().matches("\\d+")) {
            return Optional.of(Duration.ofSeconds(Long.parseLong(value.trim())));
        }
        Date date = response.headers().getDate(HEADER);
        if (date == null) {
            return Optional.empty();
        }
        Duration wait = Duration.between(now, date.toInstant());
        return Optional.of(wait.isNegative() ? Duration.ZERO : wait);
    }
}
