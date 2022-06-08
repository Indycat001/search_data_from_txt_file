package com.pps.app.exception;

public class DataIntegrityException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1149831937678037857L;
	
	public DataIntegrityException(String message) {
		super(message);
	}
	
	public DataIntegrityException(Throwable cause) {
		super(cause);
	}
	
	public DataIntegrityException(String message, Throwable cause) {
		super(message, cause);
	}

}
