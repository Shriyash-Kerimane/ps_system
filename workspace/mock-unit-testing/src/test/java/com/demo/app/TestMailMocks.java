package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public class TestMailMocks {
	@Mock
	Message message;
	
	@InjectMocks
	Mail mail = new Mail();
	
	public void testMessageWithMock() {
		when(message.getBody()).thenReturn("tea break at 4:30pm");
		assertTrue(mail.getMessage().getBody().contains("tea"));
	}
	


}
