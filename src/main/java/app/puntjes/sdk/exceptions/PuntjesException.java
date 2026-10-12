package app.puntjes.sdk.exceptions;

import app.puntjes.sdk.generated.errors.ErrorCode;
import java.util.Optional;
import java.util.OptionalInt;

/**
 * A call the Puntjes API refused, or one that got no usable answer. {@link #errorCode()} is empty for a code this
 * version does not know yet; {@link #rawCode()} holds the code as the API sent it.
 */
public class PuntjesException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private final Integer status;
    private final String rawCode;
    private final String requestId;

    public PuntjesException(ApiError error) {
        super(error.message());
        this.status = error.status();
        this.rawCode = error.code();
        this.requestId = error.requestId();
    }

    protected PuntjesException(String message, Throwable cause) {
        super(message, cause);
        this.status = null;
        this.rawCode = null;
        this.requestId = null;
    }

    /** The HTTP status, or empty when no response arrived. */
    public OptionalInt status() {
        return status == null ? OptionalInt.empty() : OptionalInt.of(status);
    }

    /** The error code, or empty when the response sent none or one this version does not know. */
    public Optional<ErrorCode> errorCode() {
        return ErrorCode.fromWire(rawCode);
    }

    /** The error code exactly as the API sent it. */
    public Optional<String> rawCode() {
        return Optional.ofNullable(rawCode);
    }

    /** Identifies the request in the Puntjes logs. Quote it when you report a problem. */
    public Optional<String> requestId() {
        return Optional.ofNullable(requestId);
    }
}
