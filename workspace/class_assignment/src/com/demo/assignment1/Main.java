package com.demo.assignment1;

public class Main {

	public static void main(String[] args) {
		
		Person john = new Person(1,"John");
		Person peter = new Person(2,"Peter","peter@nowhere.com");
		
		john.setEmail("john@nowhere.com");
		peter.setEmail("peter@everywhere.com");
		
		john.setMobile(123456789L);
		peter.setMobile(987654321L);
		
		john.getDisplay();
		peter.getDisplay();
	}

}
