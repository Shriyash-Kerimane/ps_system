package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestCalculator {
	
	Calculator cal = mock(Calculator.class);
	
	@Test
	public void printMockDetailsTest() {
		System.out.println(cal.getClass().getName());
	}
	
	@Test
	public void testAdd() {
		when(cal.add(3,7)).thenReturn(6);
		assertEquals(6, cal.add(3,7));
	}
	
	@Test
	public void testSubtract() {
		when(cal.add(3,7)).thenReturn(6);
		assertEquals(6, cal.subtract(3,7));
	}
	
	@Test
	public void testMultiply() {
		when(cal.add(3,7)).thenReturn(6);
		assertEquals(6, cal.multiply(3,7));
	}

}
