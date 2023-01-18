package com.demo.interfaces.assignment1;

public class MainRemote {

	public static void main(String[] args) {
		UniversalRemote Tv = new PanasonicTv();
		Tv.switchOff();
		Tv.switchOn();
		Tv.setChannel(5);

	}

}
