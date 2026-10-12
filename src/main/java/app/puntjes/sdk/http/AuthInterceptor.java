package app.puntjes.sdk.http;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/** Passes each request through unchanged. */
public final class AuthInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        return chain.proceed(chain.request());
    }
}
