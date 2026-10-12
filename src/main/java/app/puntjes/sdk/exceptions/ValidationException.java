package app.puntjes.sdk.exceptions;

/** HTTP 422 with VALIDATION_ERROR. Other 422 codes are refusals and throw {@link PuntjesException}. */
public final class ValidationException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public ValidationException(ApiError error) {
        super(error);
    }
}
