package com.demo.listes;

import java.util.HashSet;
import java.util.Set;

public class PersonDaoSetImpl implements PersonDao{
	Set<Person> personList=new HashSet<>();

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
	public Set<Person> listAllPersons() {
		return personList;
	}

	@Override
	public String removePerson(int id) {
		for(Person p:personList) {
			if(p.getId()==id) {
				personList.remove(p);
				return "Person removed Successfully";
			}
		}
		return "Person not found";
	}

	@Override
	public String update(Person p) {
		for(Person p1:personList) {
			if(p.getId()==p1.getId()) {
				p1.setLocation(p.getLocation());
				return "Person updated Successfully";
			}
		}
		return "Person not found";
	}

}
