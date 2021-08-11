package com.kiosk.exceptions;

public class NoSuchFoodException extends Exception {
	
	
	private static final long serialVersionUID = 1L;

	
	public NoSuchFoodException() {
	}
	
	
	public NoSuchFoodException(String errors) {
		super(errors);
	}
	

}
