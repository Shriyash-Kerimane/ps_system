package com.demo.first;

import java.util.SortedSet;
import java.util.TreeSet;

public class SortSetPerson {

	public static void main(String[] args) {
		SortedSet<Person> record= new TreeSet<>();
		record.add(new Person(1,"John","Hyderabad"));
		record.add(new Person(2,"Carter","Bangalore"));
		record.add(new Person(3,"Jack","Mumbai"));
		record.add(new Person(4,"Jill","Sirsi"));

	}

}

