package com.demo.builder.ex1;

import com.demo.builder.ex1.User.UserBuilder;

public class Email {
	
	private String setFrom;
	private String setTo;
	private String setSubject;
	private String setContent;
	
	public Email(EmailBuilder builder) {
		
		this.setFrom=builder.setFrom;
		this.setTo=builder.setTo;
		this.setSubject=builder.setSubject;
		this.setContent=builder.setContent;
		
	}
	
	static class EmailBuilder{
		private String setFrom;
		private String setTo;
		private String setSubject;
		private String setContent;
		public EmailBuilder setFrom(String setFrom) {
			this.setFrom = setFrom;
			return this;
		}
		public EmailBuilder setTo(String setTo) {
			this.setTo = setTo;
			return this;
		}
		public EmailBuilder setSubject(String setSubject) {
			this.setSubject = setSubject;
			return this;
		}
		public EmailBuilder setContent(String setContent) {
			this.setContent = setContent;
			return this;
		}
		public Email build() {
			return new Email(this);
		}
	}
}
