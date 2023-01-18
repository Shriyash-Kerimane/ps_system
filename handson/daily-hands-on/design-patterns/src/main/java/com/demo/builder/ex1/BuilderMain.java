package com.demo.builder.ex1;

public class BuilderMain {
	public static void main(String[] args) {
		User user = new User.UserBuilder(123, "name").build();
		
		User user1 = new User.UserBuilder(120, "John").email("john@email.com").city("London").build();
		User user2 = new User.UserBuilder(120, "Peter").email("peter@email.com").city("Sydney").mobile("987654321").build();
		
		StringBuilder stringBuilder=new StringBuilder();
		System.out.println(stringBuilder.append("Shriyash ").append("Kerimane ").append("9876543210"));

	}

}
