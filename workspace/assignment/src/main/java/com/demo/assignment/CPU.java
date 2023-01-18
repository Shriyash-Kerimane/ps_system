package com.demo.assignment;

public class CPU {
	private String processor;
	private int ram;
	public CPU(String processor, int ram) {
		this.processor = processor;
		this.ram = ram;
	}
	public String getDetails(){
		return " CPU with "+processor+" processor and "+ram+"GB ram ";
	}

}
