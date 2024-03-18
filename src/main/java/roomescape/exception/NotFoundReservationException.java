package roomescape.exception;

public class NotFoundReservationException extends RuntimeException {

    public NotFoundReservationException() {
    }

    public NotFoundReservationException(String message) {
        super(message);
    }

    public NotFoundReservationException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundReservationException(Throwable cause) {
        super(cause);
    }

    public NotFoundReservationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
