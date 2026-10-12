package app.puntjes.sdk.exceptions;

/** No usable answer: the connection failed, or the response broke off. */
public final class TransportException extends PuntjesException {
    private static final long serialVersionUID = 1L;

    public TransportException(String message, Throwable cause) {
        super(message, cause);
    }
}
