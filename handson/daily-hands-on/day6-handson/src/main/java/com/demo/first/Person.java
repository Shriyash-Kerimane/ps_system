package com.demo.first;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private int id;
	private String name;
	private String location;

	public Person(int id, String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public String getDetails() {
		return id + " " + name + " " + location;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		return "["+id+" "+name+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getLocation() {
		return this.location;
	}

	@Override
	public int compareTo(Person obj) {
		return this.name.compareTo(obj.name);
	}

}