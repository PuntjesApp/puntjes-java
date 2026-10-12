package app.puntjes.sdk.auth;

import java.time.Instant;

/** A bearer token from the client credentials grant and the moment it expires. */
public record AccessToken(String value, Instant expiresAt) {
    /** The expiry only: the token value stays out of logs. */
    @Override
    public String toString() {
        return "AccessToken[value=<hidden>, expiresAt=" + expiresAt + "]";
    }
}
