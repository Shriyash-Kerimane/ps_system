package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestICalculation {
	
	ICalculation cal = mock(ICalculation.class);
	
	@Test
	public void testDoCalculation() {
		when(cal.doCalculation(4, 6)).thenReturn(10.0);
		
		assertEquals(10, cal.doCalculation(4, 6));
	}

}
