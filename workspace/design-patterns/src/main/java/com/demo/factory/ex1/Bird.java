package com.demo.factory.ex1;

public interface Bird {
	
	public String getDetails();

}

class Parrot implements Bird{

	public String getDetails() {
	
		return "It is found in most of the colours in nature";
	}
}

class Crow implements Bird{

	public String getDetails() {
	
		return "It is usually black or dark gray in colour";
	}
}

class Sparrow implements Bird{

	public String getDetails() {
	
		return "It is one of the vegitarian(herbivores) bird";
	}
}

class Peacock implements Bird{

	public String getDetails() {
	
		return "One of the biggest bird which can fly";
	}
}