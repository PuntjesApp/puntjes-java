package app.puntjes.sdk.exceptions;

/** HTTP 404: the resource does not exist. */
public final class NotFoundException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public NotFoundException(ApiError error) {
        super(error);
    }
}
