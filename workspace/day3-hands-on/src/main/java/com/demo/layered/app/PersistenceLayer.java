package com.demo.layered.app;

public class PersistenceLayer {
	
	public String save(String message) {
		System.out.println("Persistence layer");
		return "Message saved";
	}

}
