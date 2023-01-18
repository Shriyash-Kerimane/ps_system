package com.demo.assignment;

public class Q2 {
	public static int getFactorial(int n) {
		int total = 1;
		if(n == 1) {
			return 1;
		}
		else{
			for(int i = 1; i<=n;i++) {
				total = total * i;
			}
		}
		return total; 
	}

}
