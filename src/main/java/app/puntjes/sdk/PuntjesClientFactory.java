package app.puntjes.sdk;

import app.puntjes.sdk.generated.PuntjesClient;
import app.puntjes.sdk.http.AuthInterceptor;
import app.puntjes.sdk.http.ErrorInterceptor;
import app.puntjes.sdk.http.RetryInterceptor;
import com.microsoft.kiota.authentication.AnonymousAuthenticationProvider;
import com.microsoft.kiota.http.OkHttpRequestAdapter;
import okhttp3.OkHttpClient;

/** Builds the generated {@link PuntjesClient} with authentication, retries and one exception family per error. */
public final class PuntjesClientFactory {
    private PuntjesClientFactory() {
    }

    /** A client for the production API with the default options. */
    public static PuntjesClient create(String clientId, String clientSecret) {
        return create(clientId, clientSecret, PuntjesOptions.builder().build());
    }

    /** A client with the given options. */
    public static PuntjesClient create(String clientId, String clientSecret, PuntjesOptions options) {
        requireText(clientId, "clientId");
        requireText(clientSecret, "clientSecret");
        OkHttpClient http = options.httpClient().map(OkHttpClient::newBuilder).orElseGet(OkHttpClient.Builder::new)
                .addInterceptor(new ErrorInterceptor())
                .addInterceptor(new RetryInterceptor(options))
                .addInterceptor(new AuthInterceptor())
                .connectTimeout(options.timeout())
                .readTimeout(options.timeout())
                .writeTimeout(options.timeout())
                .build();
        var adapter = new OkHttpRequestAdapter(new AnonymousAuthenticationProvider(), null, null, http);
        adapter.setBaseUrl(options.baseUrl());
        return new PuntjesClient(adapter);
    }

    private static void requireText(String value, String name) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(name + " must not be blank");
        }
    }
}
