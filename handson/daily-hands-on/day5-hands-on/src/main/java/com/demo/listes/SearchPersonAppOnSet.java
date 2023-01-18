package com.demo.listes;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class SearchPersonAppOnSet {

	public static void main(String[] args) {
		Set<Person> personSet=new HashSet<>();
		personSet.add(new Person(1,"John","Hyderabad"));
		personSet.add(new Person(2,"Carter","Bangalore"));
		personSet.add(new Person(3,"Jack","Mumbai"));
		personSet.add(new Person(4,"Jill","Sirsi"));
		personSet.add(new Person(5,"Nikola","Hyderabad"));
		personSet.add(new Person(6,"Tesla","Mumbai"));
		personSet.add(new Person(7,"Albert","Sirsi"));
		personSet.add(new Person(8,"Newton","Bangalore"));
		personSet.add(new Person(9,"Dalton","Hyderabad"));
		personSet.add(new Person(10,"Kelvin","Sirsi"));
		personSet.add(new Person(10,"hubble","Sirsi"));
		
		System.out.println(personSet);

	}

}
