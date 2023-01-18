package com.demo.assignment;

public class Main6 {

	public static void main(String[] args) {
		Q6 q = new Q6();
		System.out.println(q.add(10,20));
		System.out.println(q.add(10.0f,20L));
		System.out.println(q.add(10L,20L));
		System.out.println(q.add(10,20.0f));
		System.out.println(q.add(10,20,30));
		System.out.println(q.add(10,20,30.0f));

	}

}
