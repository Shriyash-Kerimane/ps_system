package com.demo.secondhalf;

import java.util.concurrent.Callable;

public class CaseChanger implements Callable<String>{
	
	private String name;
	
	public CaseChanger(String name) {
		this.name=name;
	}

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return name.toUpperCase();
	}
	
}
