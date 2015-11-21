package org.ram.http;

public class InvalidMethodException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2366312499105836040L;

	public InvalidMethodException() {
		super();
	}

	public InvalidMethodException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public InvalidMethodException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidMethodException(String message) {
		super(message);
	}

	public InvalidMethodException(Throwable cause) {
		super(cause);
	}

}
