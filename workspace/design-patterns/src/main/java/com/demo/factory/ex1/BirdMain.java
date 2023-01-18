package com.demo.factory.ex1;

public class BirdMain {

	public static void main(String[] args) {
		
		Bird bird = BirdDifference.identifyBird("Sparrow");

		System.out.println(bird.getDetails());
	}

}
