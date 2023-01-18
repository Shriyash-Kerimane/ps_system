package com.demo.threads;

public class BlockingNonBlocking {
	public static String greet() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return "Hello There!";
	}

	public static void main(String[] args) {

		new Thread(new Runnable() {

			@Override
			public void run() {
				greet();

			}
		}).start();

		System.out.println(greet());
		System.out.println("Request Completed");

	}

}