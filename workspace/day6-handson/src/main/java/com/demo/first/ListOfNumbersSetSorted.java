package com.demo.first;

import java.util.SortedSet;
import java.util.TreeSet;

public class ListOfNumbersSetSorted {

	public static void main(String[] args) {
		SortedSet<Integer> numsList= new TreeSet<>();
		
		numsList.add(7);
		numsList.add(8);
		numsList.add(6);
		numsList.add(10);
		numsList.add(3);
		numsList.add(4);
		numsList.add(7);
		numsList.add(1);
		numsList.add(9);
		
		System.out.println(numsList);
	}

}
