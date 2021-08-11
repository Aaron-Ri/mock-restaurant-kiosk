package com.kiosk.exceptions;

public class NoSuchOrderException extends Exception {


	private static final long serialVersionUID = 1L;

	
	public NoSuchOrderException() {
	}
	
	
	public NoSuchOrderException(String errors) {
		super(errors);
	}
	
	
}
