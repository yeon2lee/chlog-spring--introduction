package roomescape.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({NotFoundReservationException.class, IllegalArgumentException.class})
    public ResponseEntity handleException(RuntimeException e) {
        return ResponseEntity.badRequest().build();
    }
}
