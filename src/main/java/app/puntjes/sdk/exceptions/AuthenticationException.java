package app.puntjes.sdk.exceptions;

/** HTTP 401: the credentials or the token were refused. */
public final class AuthenticationException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public AuthenticationException(ApiError error) {
        super(error);
    }
}
