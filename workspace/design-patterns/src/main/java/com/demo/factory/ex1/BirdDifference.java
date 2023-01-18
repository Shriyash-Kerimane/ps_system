package com.demo.factory.ex1;

public class BirdDifference {
	
public static Bird identifyBird(String input) {
		
		if(input.equals("Parrot")) {
			return new Parrot();
		}else if(input.equals("Crow")) {
			return new Crow();
		}else if(input.equals("Peacock")) {
			return new Peacock();
		}else if(input.equals("Sparrow")) {
			return new Sparrow();
		}else {
			throw new RuntimeException("Cycle not supported");
		}
		
	} 

}
