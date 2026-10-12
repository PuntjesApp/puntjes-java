package app.puntjes.sdk.exceptions;

/** HTTP 403: the shop may not do this. */
public final class ForbiddenException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public ForbiddenException(ApiError error) {
        super(error);
    }
}
