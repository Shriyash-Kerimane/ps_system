package com.demo.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamOfInt {

	public static void main(String[] args) {
		List<Integer> numList=Arrays.asList(2,5,7,8,23,67,43,17,89,65);
		
//		Predicate<Integer> testEven =(x)->x%2==0;
//		numList.stream().filter(testEven).forEach(System.out::println);
		System.out.println("Step 1..................................................");
		numList.stream().filter(x->x%2==0).forEach(System.out::println);//passing object in lambda
		
		
		numList.stream().filter(x->x>24).forEach(System.out::println);

		//find all odd numbers and print
		numList.stream().filter(x->x%2==1).forEach(System.out::println);
		
		//find all the numbers >24
		
		numList.stream().filter(x->x>24).forEach(System.out::println);

		System.out.println("Step 2....................................................");
		List<Integer> evens=numList.stream().filter(x->x>24).collect(Collectors.toList());
		System.out.println(evens);
		long count=numList.stream().filter(x->x%2==0).count();
		System.out.println(count);
		
		System.out.println("Step 3.............................................");
		//int stream i.e. stream have Integer type so convert to intvalue
		//streams are lazy....when it gets terminated and then it executes
		
		
		int sum=numList.stream().filter(x->x%2==0).mapToInt(x->x.intValue()).sum();
		System.out.println(sum);
		
		System.out.println("this this");
		System.out.println(numList.stream().mapToInt(x->x.intValue()).reduce(0,(x,y)->x+y));
//		System.out.println(numList.parallelStream().mapToInt(x->x.intValue()).reduce(0,(x,y)->x+y));
		

	}

}
