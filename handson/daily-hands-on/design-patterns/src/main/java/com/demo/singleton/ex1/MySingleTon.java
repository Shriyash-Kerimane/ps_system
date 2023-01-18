package com.demo.singleton.ex1;

public class MySingleTon {
	
	private static MySingleTon singleton;
	
	private MySingleTon() {
		
		System.out.println("Singleton Instantiated");
		
	}
	
	public static MySingleTon instance() {
		
		if(singleton == null) {
			singleton = new MySingleTon();
			return singleton;
		}else {
			return singleton;
		}
	}
}
