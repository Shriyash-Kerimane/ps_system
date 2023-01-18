package com.demo.app;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.ex1.Mail;
import com.demo.ex1.MailEditor;

public class MailTest {
	
	MailEditor mailEditor = new MailEditor();
	
	Mail mail = mailEditor.compose("john@gmail.com", "peter@gmail.com", "meeting", "be present at 5:00pm today");
	
	@Test
	public void testMailEditor() {
		assertEquals("peter@gmail.com",mail.getFromAddress());
		System.out.println("this-1");
		mail.setToAddress("peter@gmail.com");
		assertEquals("peter@gmail.com",mail.getToAddress());
		System.out.println("this-2");
	}
	
	@Test
	public void testgetMessage() {
		assertEquals("be present at 5:00pm today", mail.getMessage().getBody());
		System.out.println("this-3");

	}
	
}
