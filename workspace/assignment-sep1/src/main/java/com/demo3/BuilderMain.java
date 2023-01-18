package com.demo3;

public class BuilderMain {

	public static void main(String[] args) {
		Computer computer1 = new Computer.ComputerBuilder()
								.setKeyboard("Logitech")
								.setPowerSupply("Corsair")
								.setProcessor("Intel i9 extreme")
								.build();
		
	}

}
