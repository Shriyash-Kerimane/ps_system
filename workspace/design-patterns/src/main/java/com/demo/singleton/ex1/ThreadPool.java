package com.demo.singleton.ex1;

public class ThreadPool {
	
	private static int threadCount;
	private static int count=0;
	private static ThreadPool threadPool;

	private ThreadPool() {
		
	}
	
	public static ThreadPool instance(){
		if(threadPool == null) {
			threadPool = new ThreadPool();
			threadCount = threadCount+1;
		}
		count = count +1;
		return threadPool;
	}
	
	public int getThreadCount(){
		return threadCount;
	}
	
	
}
