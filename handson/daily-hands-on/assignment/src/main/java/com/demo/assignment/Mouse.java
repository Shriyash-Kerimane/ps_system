package com.demo.assignment;

public class Mouse {
	private String type;
	private String brand;
	public Mouse(String type, String brand) {
		this.type = type;
		this.brand = brand;
	}
	
	public String getDetails() {
		return "mouse with "+type+" feature and "+brand+" brand";
	}

}
