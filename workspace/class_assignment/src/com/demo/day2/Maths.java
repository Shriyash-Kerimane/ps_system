package com.demo.day2;

/**
 * 
 * @author Shriyash Kerimane
 * This is the demonstration for static method and private constructor
 *
 */

public class Maths {
	
	/**
	 * construction of the object is restricted
	 */
	
	private Maths() {
		
	}
	
	/**
	 * 
	 * @param a input 1 for the method
	 * @param b input 2 for the method
	 * @return (a+b)
	 * 
	 */
	
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static int multiply(int a, int b) {
		return a*b;
	}
}
