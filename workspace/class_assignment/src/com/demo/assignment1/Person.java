package com.demo.assignment1;

public class Person {
	private int id;
	private String name;
	private String email = "No data";
	private long mobile = 0L;
	
	public Person(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Person(int id, String name, String email) {
		this(id,name);
		this.email = email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	public void getDisplay() {
		System.out.println(id);
		System.out.println(name);
		System.out.println(email);
		System.out.println(mobile);
		
	}
	
}