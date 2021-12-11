package org.alex.rest.exception.circus.not.found;

import org.alex.rest.exception.circus.CircusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class CircusNotFoundExceptionHandler {
    @ExceptionHandler(CircusNotFoundException.class)
    public ResponseEntity<Object> handleFarmNotFoundException(final CircusNotFoundException e) {
        CircusException farmException = new CircusException(
                e.getMessage(),
                HttpStatus.NOT_FOUND,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(farmException, HttpStatus.NOT_FOUND);
    }
}
