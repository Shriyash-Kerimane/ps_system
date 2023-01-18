package com.demo.exceptions;

import java.util.Scanner;

public class Exercise {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age = sc.nextInt();
		Exercise ex = new Exercise();
		
		try {
			System.out.println(ex.validateAge(age));
		}catch(RuntimeException e) {
			e.printStackTrace();
		}
		System.out.println("Code Ends");
	}
	
	public String validateAge(int age) {
		if (age<18) {
			throw new RuntimeException("Children are not allowed");
		}
		else if (age > 60) {
			throw new RuntimeException("Seniors are not allowed");
		}
		else 
		{
			return "Allowed";
		}
		

	}

}
