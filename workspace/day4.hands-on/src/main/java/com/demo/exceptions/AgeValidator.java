package com.demo.exceptions;

public class AgeValidator {
	public String validateAge(int age) throws InvalidAgeException {
		try {
	if (age<18) {
//		return("Children are not allowed");
		throw new InvalidAgeException("Children are not allowed");
	}
	else if (age > 60) {
//		return("Senior are not allowed");
		throw new InvalidAgeException("Seniors are not allowed");
	}
	else 
	{
		return "Allowed";
	}
		}catch(InvalidAgeException e) {
			throw e;
		}
	}

}
