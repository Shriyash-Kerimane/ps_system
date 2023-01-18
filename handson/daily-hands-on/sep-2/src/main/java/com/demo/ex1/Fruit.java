package com.demo.ex1;

public class Fruit {
	private String name;
	private Integer calories;
	
	public Fruit(String name, Integer calories) {
		this.name = name;
		this.calories = calories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}
	
	@Override
	public String toString() {
		return "( "+this.name+" "+this.calories+" )";
	}
	

}
