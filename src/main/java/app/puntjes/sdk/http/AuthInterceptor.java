package app.puntjes.sdk.http;

import app.puntjes.sdk.PuntjesOptions;
import app.puntjes.sdk.auth.AccessToken;
import app.puntjes.sdk.auth.InMemoryTokenStore;
import app.puntjes.sdk.generated.security.PublicOperations;
import java.io.IOException;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

final class AuthInterceptor implements Interceptor {
    private final TokenSource tokens;
    private final String apiPath;

    AuthInterceptor(String clientId, String clientSecret, PuntjesOptions options, OkHttpClient grants) {
        HttpUrl baseUrl = HttpUrl.get(options.baseUrl());
        this.tokens = new TokenSource(clientId, clientSecret, baseUrl,
                options.tokenStore().orElseGet(InMemoryTokenStore::new), grants);
        this.apiPath = baseUrl.encodedPath().replaceAll("/+$", "");
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (isPublic(request)) {
            return chain.proceed(request);
        }
        AccessToken token = tokens.get();
        Response response = chain.proceed(withToken(request, token));
        if (response.code() != 401) {
            return response;
        }
        response.close();
        tokens.reject(token);
        return chain.proceed(withToken(request, tokens.get()));
    }

    private boolean isPublic(Request request) {
        String path = request.url().encodedPath();
        return path.startsWith(apiPath + "/")
                && PublicOperations.matches(request.method(), path.substring(apiPath.length()));
    }

    private static Request withToken(Request request, AccessToken token) {
        return request.newBuilder().header("Authorization", "Bearer " + token.value()).build();
    }
}
