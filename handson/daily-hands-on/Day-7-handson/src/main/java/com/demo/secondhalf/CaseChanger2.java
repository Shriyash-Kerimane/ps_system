package com.demo.secondhalf;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CaseChanger2 implements Callable<String>{
	private String word = "john";

	public String call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		return word.toUpperCase();
	}
	
	public static void main(String[] args) throws Throwable {
		CaseChanger2 text = new CaseChanger2();
		ExecutorService service = Executors.newCachedThreadPool();
		Future<String> future = service.submit(text);
		System.out.println(future.get());
		service.shutdown();
	}
	
}
