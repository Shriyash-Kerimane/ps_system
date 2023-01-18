package com.demo.builder.ex1;

public class User {

	private int userId;
	private String name;
	private String email;
	private String mobile;
	private String city;
	
	public User(UserBuilder builder) {
		
		this.userId=builder.userId;
		this.name=builder.name;
		this.city=builder.city;
		this.mobile=builder.mobile;
		this.email=builder.email;
		
	}
	
	public String toString() {
		return this.userId +this.name+this.email;
	}

	 static class UserBuilder {
		private int userId;
		private String name;
		private String email;
		private String mobile;
		private String city;

		UserBuilder(int userId, String name) {
			this.userId = userId;
			this.name = name;
		}

		public UserBuilder email(String email) {
			this.email = email;
			return this;
		}

		public UserBuilder mobile(String mobile) {
			this.mobile = mobile;
			return this;
		}

		public UserBuilder city(String city) {
			this.city = city;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}
}
