package com.example.demo.spring.controllers;

import java.util.Arrays;

public class EmpNotFoundException extends RuntimeException {

	public EmpNotFoundException() {

	}
	

	public EmpNotFoundException(String message) {
		super(message);
	}


	@Override
	public String toString() {
		return this.getClass().getName()+" "+super.getMessage();
	}
	
	

	
}
