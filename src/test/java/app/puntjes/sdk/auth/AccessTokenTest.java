package app.puntjes.sdk.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class AccessTokenTest {
    @Test
    void theTextFormHidesTheTokenValue() {
        AccessToken token = new AccessToken("secret-bearer-value", Instant.parse("2030-01-01T00:00:00Z"));

        assertEquals("AccessToken[value=<hidden>, expiresAt=2030-01-01T00:00:00Z]", token.toString());
    }
}
