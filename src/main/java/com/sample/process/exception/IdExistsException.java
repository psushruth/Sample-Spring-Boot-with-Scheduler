package com.sample.process.exception;

public class IdExistsException extends RuntimeException {

    public IdExistsException(final String message) {
        super(message);
    }
}
