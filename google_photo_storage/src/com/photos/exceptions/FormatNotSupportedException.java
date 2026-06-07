package com.photos.exceptions;

/**
 * Thrown when a photo format is not supported by the application.
 */
public class FormatNotSupportedException extends Exception {

    public FormatNotSupportedException(String message) {
        super(message);
    }
}
