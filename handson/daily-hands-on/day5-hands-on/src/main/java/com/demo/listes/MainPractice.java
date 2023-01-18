package com.demo.listes;

import java.util.ArrayList;
import java.util.List;

public class MainPractice {

	public static void main(String[] args) {
		PersonDao record = new PersonDaoImpl();
		List<Person> personList=new ArrayList<>();
		record.savePerson(new Person(1,"John","Hyderabad"));
		record.savePerson(new Person(2,"Carter","Bangalore"));
		record.savePerson(new Person(3,"Jack","Mumbai"));
		record.savePerson(new Person(4,"Jill","Sirsi"));
		
		System.out.println(record.findById(2));
		System.out.println(record.listAllPersons());


	}

}
