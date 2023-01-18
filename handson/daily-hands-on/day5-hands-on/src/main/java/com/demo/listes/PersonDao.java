package com.demo.listes;

import java.util.List;

public interface PersonDao{
	
	public Person findById(int id);
	public String savePerson(Person p);
	public List<Person> listAllPersons();
	

}
