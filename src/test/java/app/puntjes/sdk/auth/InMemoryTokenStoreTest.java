package app.puntjes.sdk.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Instant;
import java.util.Optional;
import org.junit.jupiter.api.Test;

class InMemoryTokenStoreTest {
    private static final Instant EXPIRY = Instant.parse("2030-01-01T00:00:00Z");

    @Test
    void removingTheStoredTokenEmptiesTheKey() {
        InMemoryTokenStore store = new InMemoryTokenStore();
        store.put("shop", new AccessToken("token-1", EXPIRY));

        store.remove("shop", new AccessToken("token-1", EXPIRY));

        assertTrue(store.get("shop").isEmpty());
    }

    @Test
    void removingAnOtherTokenKeepsTheStoredOne() {
        InMemoryTokenStore store = new InMemoryTokenStore();
        AccessToken granted = new AccessToken("token-2", EXPIRY);
        store.put("shop", granted);

        store.remove("shop", new AccessToken("token-1", EXPIRY));

        assertEquals(Optional.of(granted), store.get("shop"));
    }
}
