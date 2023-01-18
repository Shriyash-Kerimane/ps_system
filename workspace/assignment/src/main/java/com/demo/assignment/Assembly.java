package com.demo.assignment;

public class Assembly {
	public Assembly() {
		Monitor m = new Monitor(24, "dell");
		Keyboard k = new Keyboard("with Backlit","Logitech");
		Mouse ms = new Mouse("Wireless", "Logitech");
		CPU c = new CPU("i7",16);
		Monitor m1 = new Monitor(20, "hp");
		Keyboard k1 = new Keyboard("without Backlit","Logitech");
		Mouse ms1 = new Mouse("Wired", "Logitech");
		CPU c1 = new CPU("i9",32);
		AssembleComputer ac = new AssembleComputer(m,k,ms1,c1);
		System.out.println(ac.getDetails());
	}
}
