package com.demo.listes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPersonApp {

	public static void main(String[] args) {
		List<Person> personList=new ArrayList<>();
		personList.add(new Person(1,"John","Hyderabad"));
		personList.add(new Person(2,"Carter","Bangalore"));
		personList.add(new Person(3,"Jack","Mumbai"));
		personList.add(new Person(4,"Jill","Sirsi"));
		personList.add(new Person(5,"Nikola","Hyderabad"));
		personList.add(new Person(6,"Tesla","Mumbai"));
		personList.add(new Person(7,"Albert","Sirsi"));
		personList.add(new Person(8,"Newton","Bangalore"));
		personList.add(new Person(9,"Dalton","Hyderabad"));
		personList.add(new Person(10,"Kelvin","Sirsi"));

		
		Scanner sc = new Scanner(System.in);
		int check = sc.nextInt();
		for(Person p:personList) {
			if(p.getId()==check) {
				System.out.println(p.getDetails());
				break;
			}
		}

	}

}
