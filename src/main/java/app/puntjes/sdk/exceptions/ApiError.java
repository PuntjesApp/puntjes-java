package app.puntjes.sdk.exceptions;

import java.util.List;
import java.util.Map;

/**
 * The parts of an error response that an exception carries. {@code code} and {@code requestId} are null when the
 * response did not send them; {@code details} holds the messages of each rejected field, and is empty when none came.
 */
public record ApiError(int status, String code, String message, String requestId, Map<String, List<String>> details) {
}
