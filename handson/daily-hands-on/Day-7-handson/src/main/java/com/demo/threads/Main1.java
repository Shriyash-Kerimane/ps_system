package com.demo.threads;

public class Main1 {

	public static void main(String[] args) throws InterruptedException {
		String name=Thread.currentThread().getName();
		System.out.println(Thread.currentThread().getPriority());
		System.out.println("thread.."+name+" started");
		MyThread t1 = new MyThread();
		t1.setName("John");
		t1.start();
		
		MyThread t2 = new MyThread();
		t2.setName("Cena");
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("thread.."+name+" ended");

	}

}
