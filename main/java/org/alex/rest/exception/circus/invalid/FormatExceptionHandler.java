package org.alex.rest.exception.circus.invalid;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.alex.rest.exception.circus.CircusException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class FormatExceptionHandler {
    @ExceptionHandler(InvalidFormatException.class)
    public ResponseEntity<Object> handleInvalidFormatException(final InvalidFormatException e) {
        CircusException farmException = new CircusException(
                e.getMessage(),
                HttpStatus.BAD_REQUEST,
                ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(farmException , HttpStatus.BAD_REQUEST);
    }

}
