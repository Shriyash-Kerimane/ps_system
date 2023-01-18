package com.demo.assignment;

public class Monitor {
	private int inch;
	private String brand;
	
	public Monitor(int inch, String brand) {
		this.inch = inch;
		this.brand = brand;
	}
	public String getDetails() {
		return "Monitor with "+inch+" inches and "+brand+" brand";
	}

}
