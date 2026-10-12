package app.puntjes.sdk.exceptions;

/**
 * The parts of an error response that an exception carries. {@code code} and {@code requestId} are null when the
 * response did not send them.
 */
public record ApiError(int status, String code, String message, String requestId) {
}
