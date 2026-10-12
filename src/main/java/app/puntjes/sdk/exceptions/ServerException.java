package app.puntjes.sdk.exceptions;

/** HTTP 5xx. */
public final class ServerException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public ServerException(ApiError error) {
        super(error);
    }
}
