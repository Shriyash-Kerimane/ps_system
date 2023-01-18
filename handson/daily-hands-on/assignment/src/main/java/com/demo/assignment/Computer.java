package com.demo.assignment;

public class Computer {
	public Computer() {
	Monitor m = new Monitor(24, "dell");
	Keyboard k = new Keyboard("with Backlit","Logitech");
	Mouse ms = new Mouse("Wireless", "Logitech");
	CPU c = new CPU("i7",16);
	
	System.out.println("Specification of Computer are : "+m.getDetails()+", "+k.getDetails()+", "+ms.getDetails()+", "+c.getDetails());
	}
}
