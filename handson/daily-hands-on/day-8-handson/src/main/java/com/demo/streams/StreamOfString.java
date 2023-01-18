package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamOfString {

	public static void main(String[] args) {
		System.out.println("Step1..........................................................");
		List<String> names = Arrays.asList("john","peter","jack","jill","zeeta","theta","omega","epsilon");
		System.out.println(names);
		
		//find all the names having length more than 6 chars
		List<String> names6 = names.stream().filter(x->x.length()>6).collect(Collectors.toList());
		System.out.println(names6);
		
		//convert all the names to uppercase
		List<String> uppercase = names.stream().map(String::toUpperCase).collect(Collectors.toList());
		System.out.println(uppercase);
		
		//calculate the length of each name and collect them in a list
		long length = names.stream().filter(x->x.length()>6).count();
		System.out.println(length);		
		
		//add welcome to every name
		List<String> welcome = names.stream().map(x->"Welcome "+x).collect(Collectors.toList());
		System.out.println(welcome);
		
		//sort all the names in ascending order
		List<String> sorted = names.stream().sorted().collect(Collectors.toList());
		System.out.println(sorted);
		
		
	}

}
