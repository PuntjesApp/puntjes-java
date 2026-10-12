package app.puntjes.sdk.auth;

import java.util.Optional;

/** Keeps access tokens between calls. One store can serve many shops: each token sits under its own key. */
public interface TokenStore {
    /** The token stored under the key, if any. */
    Optional<AccessToken> get(String key);

    /** Stores the token under the key. */
    void put(String key, AccessToken token);

    /** Removes the token under the key, but only while its value is still the value of the rejected one. */
    void remove(String key, AccessToken rejected);
}
