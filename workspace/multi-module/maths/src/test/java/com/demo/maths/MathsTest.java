package com.demo.maths;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MathsTest {
	@Test
	public void testAdd() {
		Maths m = new Maths();
		assertEquals(4, m.add(2, 2));
	}
}