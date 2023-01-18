package com.demo.listes;

import java.util.Set;

public interface PersonDao{
	
	public Person findById(int id);
	public String savePerson(Person p);
	public Set<Person> listAllPersons();
	public String removePerson(int id);
	public String update(Person p);
	

}
