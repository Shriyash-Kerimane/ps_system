package com.demo.assignment;

public class AssembleComputer {
	private Monitor monitor;
	private Keyboard keyboard;
	private Mouse mouse;
	private CPU cpu;
	public AssembleComputer(Monitor monitor, Keyboard keyboard, Mouse mouse, CPU cpu) {
		this.monitor = monitor;
		this.keyboard = keyboard;
		this.mouse = mouse;
		this.cpu = cpu;
	}
	public String getDetails() {		
		return "Specification of Computer are : "+this.monitor.getDetails()+", "+this.keyboard.getDetails()+", "+this.mouse.getDetails()+", "+this.cpu.getDetails();
	}
		
}
