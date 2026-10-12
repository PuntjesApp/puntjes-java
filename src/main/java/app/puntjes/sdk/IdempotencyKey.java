package app.puntjes.sdk;

import java.util.UUID;

/** Makes the {@code idempotency_key} a points-moving call needs. Send the same key again to repeat the call safely. */
public final class IdempotencyKey {
    private IdempotencyKey() {
    }

    /** A new random version 4 UUID in its canonical text form. */
    public static String newKey() {
        return UUID.randomUUID().toString();
    }
}
