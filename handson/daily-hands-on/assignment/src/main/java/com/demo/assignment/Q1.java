package com.demo.assignment;

import java.util.*;

public class Q1 {
	public void details() {
		int x,y,z;
		Scanner sc=new Scanner(System.in);
		System.out.println("enter 1st number");
		x=sc.nextInt();
		
		System.out.println("enter 2nd number");
		y=sc.nextInt();
		
		System.out.println("enter 3rd number");
		z=sc.nextInt();
		
		if (x>y && x>z) {
			System.out.println("largest number is "+x);
		}
		else if (y>z) {
			System.out.println("largest number is "+y);
		}
		else
			System.out.println("largest number is "+z);
	}
}