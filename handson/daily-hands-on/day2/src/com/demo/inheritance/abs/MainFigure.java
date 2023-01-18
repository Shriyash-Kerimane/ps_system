package com.demo.inheritance.abs;

public class MainFigure {

	public static void main(String[] args) {
		Rectangle R1 = new Rectangle(10,20);
		Triangle T1 = new Triangle(10,20);
		
		System.out.println(R1.area());
		System.out.println(T1.area());

	}

}
