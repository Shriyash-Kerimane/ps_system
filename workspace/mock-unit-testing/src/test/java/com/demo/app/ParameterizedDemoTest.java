package com.demo.app;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParameterizedDemoTest {
	Calculator cal = new Calculator();	
	
	@ParameterizedTest
	@ValueSource(strings = {"hello","world","zoo","animals"})
	public void testArgs(String param) {
		assertNotNull(param);
	}
	
	@ParameterizedTest
	@CsvSource({"1, 1, 2","2,3,5"})
	public void testAddForData(int a, int b, int result) {
		Assertions.assertEquals(result,cal.add(a,b));
	}
	
	@ParameterizedTest
	@CsvFileSource(files = {"data.csv"})
	public void testAddForCSVData(int a, int b, int result) {
		Assertions.assertEquals(result,cal.add(a,b));
	}
	
}
