package com.demo.singleton.ex1;

public class DemoDemo {

	public static void main(String[] args) {
		
		CheckDemo c = new CheckDemo();
		c.setData1(5);
		System.out.println(c.getData1());
		
		CheckDemo2 c2 = new CheckDemo2();
		c2.setData2(10);
		System.out.println(c2.getData2());
	}

}

class CheckDemo{
	private int data1;
	public int getData1() {
		return data1;
	}
	public void setData1(int data1) {
		this.data1 = data1;
	}
}

class CheckDemo2{
	private int data2;
	public CheckDemo2() {
		System.out.println("This is constructor");
	}
	public int getData2() {
		return data2;
	}
	public void setData2(int data2) {
		this.data2 = data2;
	}
	
}