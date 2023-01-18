package com.demo.listes;

import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao{
	List<Person> personList=new ArrayList<>();

	@Override
	public Person findById(int id) {
		for(Person p:personList) {
			if(p.getId()==id) {
				System.out.println(p.getDetails());
				return p;
			}
		}
		
		
		return null;
	}

	@Override
	public String savePerson(Person p) {
		personList.add(p);
		return "Success";
	}

	@Override
	public List<Person> listAllPersons() {
		
		return personList;
	}

}
