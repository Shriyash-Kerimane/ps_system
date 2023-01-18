package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

public class TestICal {

	ICal cal = mock(ICal.class);

	@Test
	public void testAdd()
	{
		when(cal.add(4, 6)).thenReturn(100);
		assertEquals(100, cal.add(4, 6));
	}
	
	@Test
	public void testSubtract()
	{
		when(cal.subtract(4, 6)).thenReturn(100);
		assertEquals(100, cal.subtract(4, 6));
	}
	
	@Test
	public void testMultiply()
	{
		when(cal.multiply(4, 6)).thenReturn(100);
		assertEquals(100, cal.multiply(4, 6));
	}
	
	@Test
	public void testDivide()
	{
		when(cal.divide(4, 6)).thenReturn(100);
		assertEquals(100, cal.divide(4, 6));
	}
	
	Message message = mock(Message.class);
	Mail mail = new Mail();
	
	@Test
	public void testMessage() {
		when(message.getBody()).thenReturn("hello");
		mail.setMessage(message);
		assertTrue(mail.getMessage().getBody().contains("hello1"));
	}
	
	
	

}
