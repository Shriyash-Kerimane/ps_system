package com.demo.day5;

public class PersonMain {

	public static void main(String[] args) {
		Person p1 = new Person(100, "John");
		Person p2 = new Person(100, "John");
		
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());
		
		String p3 = "Hello";

		System.out.println(p1.equals(p2));
		System.out.println(p1.getClass());
		System.out.println(p3.getClass());
		
	}

}
