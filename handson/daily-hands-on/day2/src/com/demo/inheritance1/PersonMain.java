package com.demo.inheritance1;

public class PersonMain {

	public static void main(String[] args) {
		Person peter= new Person(101,"Peter","Banglore");
		Student st= new Student(100,"John","Hyderabad","Excellent");
		System.out.println(st.getDetails());
		System.out.println(peter.getDetails());

	}

}
