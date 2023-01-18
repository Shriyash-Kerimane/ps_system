package com.demo.secondhalf;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class CallableDemo2{
	public static void main(String[] args) throws Exception{
	
	ThreadPoolExecutor es = (ThreadPoolExecutor)Executors.newFixedThreadPool(4);
	ArrayList<CaseChanger> threads = new ArrayList<>();
	threads.add(new CaseChanger("Hello World"));
	threads.add(new CaseChanger("Hello "));
	threads.add(new CaseChanger("Hey World"));
	threads.add(new CaseChanger("Hey"));
	
	List<Future<String>>futureList =es.invokeAll(threads);
	System.out.println("call made");
	
	do {
		System.out.println("waiting for result");
		Thread.sleep(1000);
		
	} while (es.getCompletedTaskCount()<futureList.size());
	
	for(Future<String>f:futureList) {
		System.out.println(f.get());
	}
	es.shutdown();
	}
}
