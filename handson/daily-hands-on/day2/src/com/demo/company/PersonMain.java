package com.demo.company;

public class PersonMain {

	public static void main(String[] args) {
		Person jack= new Person(101,"jack","Bangalore");
		Employee peter= new Employee(102,"Peter","Bangalore",50000);
		TraineeEmp Jill = new TraineeEmp(100,"Jill","Hyderabad",100000L,"Excellent");
		
		System.out.println(Jill.getDetails());
		System.out.println(peter.getDetails());
		System.out.println(jack.getDetails());
		
		/**
		 * Superclass type as a reference to the subclass object
		 */
//		Person p = peter;
//		System.out.println(p.getDetails());
//		
//		p=Jill;
//		System.out.println(p.getDetails());
		
	}

}
