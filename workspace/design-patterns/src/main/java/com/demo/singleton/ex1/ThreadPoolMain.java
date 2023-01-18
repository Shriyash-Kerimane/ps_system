package com.demo.singleton.ex1;

public class ThreadPoolMain {

	public static void main(String[] args) {
		ThreadPool thread1 = ThreadPool.instance();
		ThreadPool thread2 = ThreadPool.instance();
		
		int result = thread1.getThreadCount();
		
		System.out.println(result);
	}

}
