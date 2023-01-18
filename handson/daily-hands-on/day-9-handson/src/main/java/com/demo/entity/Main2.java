package com.demo.entity;

public class Main2 {

	public static void main(String[] args) {
		GenericsApp<Integer> app1 = new GenericsApp<>();
		app1.setData(3, 4);
		
		System.out.println(app1.getData());
		
		GenericsApp<String> app2 = new GenericsApp<>();
		app2.setData("Nikola", "Tesla");
		
		System.out.println(app2.getData());

	}

}
