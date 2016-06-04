package com.sample.process.exception;

public class IdExistsException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public IdExistsException(final String message) {
        super(message);
    }
}
