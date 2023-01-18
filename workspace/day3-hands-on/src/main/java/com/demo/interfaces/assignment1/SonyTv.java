package com.demo.interfaces.assignment1;

public class SonyTv implements UniversalRemote{

	@Override
	public void switchOn() {
		System.out.println("SonyTv is turned ON");
		
	}

	@Override
	public void switchOff() {
		System.out.println("SonyTv is turned Off");
		
	}

	@Override
	public void setChannel(int ch) {
		System.out.println("changed channel to"+" "+ch);
		
	}

}
