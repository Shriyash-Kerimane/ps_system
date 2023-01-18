package com.demo4;

public class HeatingSystem  {

    public void heatOn() {
        System.out.println("Turned on heat");
    }

    public void heatOff() {
        System.out.println("Turned off heat");
    }
}

interface Command {

	public void execute();
}

class OnCommand implements Command {
	HeatingSystem heater;

	public OnCommand(HeatingSystem heater) {
		this.heater = heater;
	}

	@Override
	public void execute() {
		heater.heatOn();
	}
}

class OffCommand implements Command {
	HeatingSystem heater;

	public OffCommand(HeatingSystem heater) {
		this.heater = heater;
	}

	@Override
	public void execute() {
		heater.heatOff();
	}

}

class Remote {
	OnCommand onCommand;
	OffCommand offCommand;

	public Remote(OnCommand onCommand, OffCommand offCommand) {
		this.onCommand = onCommand;
		this.offCommand = offCommand;
	}

	public void on() {
		onCommand.execute();
	}

	public void off() {
		offCommand.execute();
	}
}

class Client {

	public static void main(String[] args) {
		HeatingSystem heater = new HeatingSystem();
		OnCommand on = new OnCommand(heater);
		OffCommand off = new OffCommand(heater);

		Remote remote = new Remote(on, off);
		
		remote.on();
		remote.off();
	}
}
