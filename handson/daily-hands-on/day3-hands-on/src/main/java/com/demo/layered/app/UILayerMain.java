package com.demo.layered.app;

public class UILayerMain {

	public static void main(String[] args) {
		ServiceLayer service=new ServiceLayer();
		String result=service.compose("Assignment","Panic");
		System.out.println(result);

	}

}
