package com.demo.assignment;

public class Keyboard {
	private String backlit;
	private String brand;
	public Keyboard(String backlit, String brand) {
		this.backlit = backlit;
		this.brand = brand;
	}
	public String getDetails() {
		return "keyboard "+backlit+" and "+brand+" brand ";
	}
}
