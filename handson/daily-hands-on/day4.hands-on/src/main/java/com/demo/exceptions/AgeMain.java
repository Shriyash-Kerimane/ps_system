package com.demo.exceptions;

import java.util.Scanner;

public class AgeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		AgeValidator validator = new AgeValidator();
		try {
		System.out.println(validator.validateAge(age));
		}catch(InvalidAgeException e) {
			System.out.println("You are not allowed");
		}
		System.out.println("Program Ended Normally");

	}

}
