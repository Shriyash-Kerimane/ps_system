package com.demo.builder.ex1;

public class MainEmail {

	public static void main(String[] args) {
		
		Email email = new Email.EmailBuilder()
	              .setFrom("Nilkola@gmail.com")
	              .setTo("T_Edison@gmail.com")
	              .setSubject("Patent Innovation")
	              .setContent("AC future of transmission").build();

	}

}
