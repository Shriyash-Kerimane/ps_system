package com.demo.first;

public class Calculator {
	
	public int getadd() {
		NumberGenerator n = new NumberGenerator();
		return  (n.getFirstNumber()+n.getSecondNumber());
	}
}
