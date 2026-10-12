package app.puntjes.sdk.http;

import app.puntjes.sdk.PuntjesOptions;
import okhttp3.OkHttpClient;

/** Builds the HTTP client behind {@code PuntjesClientFactory}. Not meant to be called by applications. */
public final class HttpClients {
    private HttpClients() {
    }

    /** The client with authentication, retries and one exception family per error, as the options say. */
    public static OkHttpClient build(String clientId, String clientSecret, PuntjesOptions options) {
        OkHttpClient base = options.httpClient().map(OkHttpClient::newBuilder).orElseGet(OkHttpClient.Builder::new)
                .connectTimeout(options.timeout())
                .readTimeout(options.timeout())
                .writeTimeout(options.timeout())
                .build();
        OkHttpClient grants = base.newBuilder()
                .addInterceptor(new RetryInterceptor(options))
                .build();
        return base.newBuilder()
                .addInterceptor(new ErrorInterceptor())
                .addInterceptor(new RetryInterceptor(options))
                .addInterceptor(new AuthInterceptor(clientId, clientSecret, options, grants))
                .build();
    }
}
