package app.puntjes.sdk.auth;

import java.time.Instant;

/** A bearer token from the client credentials grant and the moment it expires. */
public record AccessToken(String value, Instant expiresAt) {
}
