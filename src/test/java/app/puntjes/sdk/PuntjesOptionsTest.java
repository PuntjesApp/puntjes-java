package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.Test;

class PuntjesOptionsTest {
    @Test
    void theDefaultsAimAtProductionWithTwoRetries() {
        PuntjesOptions options = PuntjesOptions.builder().build();

        assertEquals("https://puntjes.app/api/v1", options.baseUrl());
        assertEquals(2, options.maxRetries());
        assertEquals(Duration.ofMillis(500), options.retryBaseDelay());
        assertEquals(Duration.ofSeconds(30), options.timeout());
        assertTrue(options.tokenStore().isEmpty());
        assertTrue(options.httpClient().isEmpty());
    }

    @Test
    void aTrailingSlashIsRemovedFromTheBaseUrl() {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl("https://shop.test/api/v1/").build();

        assertEquals("https://shop.test/api/v1", options.baseUrl());
    }

    @Test
    void aNegativeRetryCountIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> PuntjesOptions.builder().maxRetries(-1));
    }

    @Test
    void aNegativeDurationIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> PuntjesOptions.builder().timeout(Duration.ofSeconds(-1)));
        assertThrows(IllegalArgumentException.class,
                () -> PuntjesOptions.builder().retryBaseDelay(Duration.ofMillis(-1)));
    }
}
