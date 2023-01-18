package com.demo.exceptions;

public class InvalidAgeException extends Exception {
	public InvalidAgeException() {

	}

	public InvalidAgeException(String message) {
		super(message);

	}
	@Override
	public String toString() {
		
		return this.getClass().getName()+" : "+super.getMessage();
	}

}
