package com.demo.threads.sync;

public class TableGenerator {
	
	public synchronized void genTable(int x) {
		System.out.println();
		for(int i = 1;i<11;i++) {
			try {				
			System.out.println(x+"x"+i+" = "+(x*i));
			Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
