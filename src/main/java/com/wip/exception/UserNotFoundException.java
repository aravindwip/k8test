package com.wip.exception;

public class UserNotFoundException extends Exception {

	public UserNotFoundException() {
		super();
		
	}

	public UserNotFoundException(String message) {
		super(message);
		System.out.println("UserNotFoundException: " + message);
	}
	
}
