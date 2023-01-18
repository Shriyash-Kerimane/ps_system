package com.demo.inheritance.abs;

public class Rectangle extends Figure {

	public Rectangle(int dimension1, int dimension2) {
		super(dimension1, dimension2);
		
	}
	
	@Override
	public double area() {
		return (dimension1*dimension2);
	}

}
