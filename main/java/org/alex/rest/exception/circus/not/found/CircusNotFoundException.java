package org.alex.rest.exception.circus.not.found;

public class CircusNotFoundException extends RuntimeException{

    public CircusNotFoundException(final String message) {
        super(message);
    }

    public CircusNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
