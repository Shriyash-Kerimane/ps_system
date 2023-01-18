package com.demo.ex1;

import java.util.Arrays;
import java.util.List;

public class ForEachWithLambda {

	public static void main(String[] args) {
		List<String> fruits = Arrays.asList("apple","banana","pear","orange","mango");
	
//		fruits.forEach((String s)->System.out.println(s));
//		fruits.forEach(s->System.out.println(s));
		fruits.forEach(System.out::println); //:: is method reference
		
		//for non static method do as below
		ForEachWithLambda l = new ForEachWithLambda();
		
//		fruits.forEach(l::print);
//
//	}
//	public void print() {
//		System.out.println();
//	}

	}}
