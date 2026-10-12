package app.puntjes.sdk.auth;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/** Keeps the tokens in this process. The default store. */
public final class InMemoryTokenStore implements TokenStore {
    private final ConcurrentMap<String, AccessToken> tokens = new ConcurrentHashMap<>();

    @Override
    public Optional<AccessToken> get(String key) {
        return Optional.ofNullable(tokens.get(key));
    }

    @Override
    public void put(String key, AccessToken token) {
        tokens.put(key, token);
    }

    @Override
    public void remove(String key, AccessToken rejected) {
        tokens.remove(key, rejected);
    }
}
