package app.puntjes.sdk;

import okhttp3.OkHttpClient;

final class HttpClients {
    private HttpClients() {
    }

    static OkHttpClient build(String clientId, String clientSecret, PuntjesOptions options) {
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
