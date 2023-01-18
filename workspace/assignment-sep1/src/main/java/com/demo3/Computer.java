package com.demo3;

public class Computer {

	String memory;
	String processor;
	String powerSupply;
	String monitor;
	String keyboard;
	String speakers;
	String mouse;

	public Computer(ComputerBuilder builder) {
		this.memory = builder.memory;
		this.processor = builder.processor;
		this.powerSupply = builder.powerSupply;
		this.monitor = builder.monitor;
		this.keyboard = builder.keyboard;
		this.speakers = builder.speakers;
		this.mouse = builder.mouse;
	}
		
	
	static class ComputerBuilder {
		String memory;
		String processor;
		String powerSupply;
		String monitor;
		String keyboard;
		String speakers;
		String mouse;

		public ComputerBuilder setMemory(String memory) {
			this.memory = memory;
			return this;
		}

		public ComputerBuilder setProcessor(String processor) {
			this.processor = processor;
			return this;
		}

		public ComputerBuilder setPowerSupply(String powerSupply) {
			this.powerSupply = powerSupply;
			return this;

		}

		public ComputerBuilder setMonitor(String monitor) {
			this.monitor = monitor;
			return this;
		}

		public ComputerBuilder setKeyboard(String keyboard) {
			this.keyboard = keyboard;
			return this;
		}

		public ComputerBuilder setSpeakers(String speakers) {
			this.speakers = speakers;
			return this;
		}

		public ComputerBuilder setMouse(String mouse) {
			this.mouse = mouse;
			return this;
		}
		
		public Computer build() {
			return new Computer(this);
		}
	}
}
