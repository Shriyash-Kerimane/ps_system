package com.demo.singleton.ex1;

public class MySingleTon {
	
	private static MySingleTon singleton;
	private static int count=0;
	private MySingleTon() {
		
		System.out.println("Singleton Instantiated");
		
	}
	
	public static MySingleTon instance() {
		
		if(singleton == null) {
			count++;
			singleton = new MySingleTon();
			return singleton;
		}else {
			count++;
			return singleton;
		}
	}
	
	public static int getCount() {
		return count;
	}
}
