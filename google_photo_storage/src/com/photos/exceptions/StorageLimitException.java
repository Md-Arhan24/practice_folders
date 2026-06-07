package com.photos.exceptions;

/**
 * Thrown when the user exceeds available storage space.
 */
public class StorageLimitException extends Exception {

    public StorageLimitException(String message) {
        super(message);
        // Hint: Check available space, suggest upgrade options, handle large files
    }
}

