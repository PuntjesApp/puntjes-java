package app.puntjes.sdk.exceptions;

/** HTTP 409: the request conflicts with data that already exists. */
public final class ConflictException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public ConflictException(ApiError error) {
        super(error);
    }
}
