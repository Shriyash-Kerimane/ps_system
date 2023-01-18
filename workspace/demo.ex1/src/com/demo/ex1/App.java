package com.demo.ex1;

public class App {

	public static void main(String[] args) {
		Box b = new Box(10,20,30);
		System.out.println(b.getColor());
		
		Box b1 = new Box(10,20,30,"blue");
		System.out.println(b1.getColor());
		
		Box b4 = new Box(10,20,20,"Red",65.6);
		System.out.println(b4.getDensity());
		
		b.getVolume();
		System.out.println(b.getVolume());
		

	}

}
