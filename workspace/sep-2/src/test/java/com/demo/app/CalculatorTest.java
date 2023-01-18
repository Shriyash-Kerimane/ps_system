package com.demo.app;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import assignment.Calculator;


public class CalculatorTest {
	
	@Test
	public void testJupiterSetup() {
		System.out.println("Test Done");
	}
	
	@RepeatedTest(value = 4)
	public void testAddFor2ints() {
		Calculator cal = new Calculator();
		Assertions.assertEquals(6, cal.add(3,3));
	}
	
	@Test
	public void testSubtractFor2ints() {
		Calculator cal = new Calculator();
		Assertions.assertEquals(3, cal.subtract(6,3));
	}
	
	@Test
	public void testMultiplyFor2ints() {
		Calculator cal = new Calculator();
		Assertions.assertEquals(9, cal.multiply(3,3));
	}
	
	@Test
	public void testDivideFor2ints() {
		Calculator cal = new Calculator();
		Assertions.assertEquals(1, cal.divide(3,3));
	}

}
