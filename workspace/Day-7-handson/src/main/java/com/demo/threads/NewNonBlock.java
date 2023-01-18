package com.demo.threads;

public class NewNonBlock {
	public static String greet() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "hello there";
	}
	
	public static void main(String[] args) {
		System.out.println("Request completed...");
		System.out.println(greet());
		
	}

}
