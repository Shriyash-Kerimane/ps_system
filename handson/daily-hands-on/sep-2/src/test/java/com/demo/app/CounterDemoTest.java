package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)

public class CounterDemoTest{
	
	CounterDemo counter;
	
	@BeforeAll //BeforeEach as option
	public void init() {
		counter = new CounterDemo();
	}
	
	@Test
	@DisplayName("Tests the counter for 2 increments")
	public void testIncrement2times() {
		counter.increment();
		counter.increment();
		assertEquals(2, counter.getCount());
	}
	
	@Test
	public void testDecrement2times() {
		counter.decrement();
		counter.decrement();
		assertEquals(-2, counter.getCount());
	}
	
	@AfterAll
	public void cleanup() {
		counter = null;
	}
	
}