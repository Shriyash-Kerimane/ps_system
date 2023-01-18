package com.demo.ex1;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;


public class Main2 {

	public static void main(String[] args) {
		
		Predicate<Integer> p =(Integer t)->(t<10);
		
		Consumer<String> c=s-> System.out.println(s);
		
		Supplier<String> s=()->"Hello World";
		
		Function<String, String> f =name->"Hello"+name;
		
		

	}

}
