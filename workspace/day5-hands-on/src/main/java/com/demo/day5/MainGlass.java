package com.demo.day5;

public class MainGlass {

	public static void main(String[] args) {
		Glass<Juice> glass = new Glass<>();
		glass.liquid=new Juice();
		
		Glass<Water> glass1 = new Glass<>();
		glass1.liquid  = new Water();
		
		Water water = glass1.liquid;	

	}

}
