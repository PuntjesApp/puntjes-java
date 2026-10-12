package app.puntjes.sdk;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"https://shop.test", "https://shop.test/", "https://shop.test/api/v1",
            "https://shop.test/api/v1/", "https://shop.test/API/V1"})
    void theBaseUrlIsTakenWithOrWithoutTheApiPrefix(String baseUrl) {
        PuntjesOptions options = PuntjesOptions.builder().baseUrl(baseUrl).build();

        assertEquals("https://shop.test/api/v1", options.baseUrl());
    }

    @Test
    void aNegativeRetryCountIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> PuntjesOptions.builder().maxRetries(-1));
    }

    @Test
    void moreThanTenRetriesAreRefused() {
        assertEquals(10, PuntjesOptions.builder().maxRetries(10).build().maxRetries());
        assertThrows(IllegalArgumentException.class, () -> PuntjesOptions.builder().maxRetries(11));
    }

    @Test
    void aNegativeDurationIsRefused() {
        assertThrows(IllegalArgumentException.class, () -> PuntjesOptions.builder().timeout(Duration.ofSeconds(-1)));
        assertThrows(IllegalArgumentException.class,
                () -> PuntjesOptions.builder().retryBaseDelay(Duration.ofMillis(-1)));
    }
}
