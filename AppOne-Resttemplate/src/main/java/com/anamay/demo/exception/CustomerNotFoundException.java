package com.anamay.demo.exception;

public class CustomerNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException() {
		super("Customer Not Found");
	}

}
