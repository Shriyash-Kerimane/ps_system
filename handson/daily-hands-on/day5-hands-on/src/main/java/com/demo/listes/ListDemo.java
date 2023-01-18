package com.demo.listes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<String> namesList =new ArrayList<>();
//		List<String> namesList =new LinkedList<>();
//		List<String> namesList =new Vector<>();
		
		namesList.add("John");
		namesList.add("peter");
		namesList.add("Jack");
		namesList.add("srinivas");
		namesList.add(0, "peterson");
		namesList.remove(2);
		System.out.println(namesList);
		System.out.println(namesList.contains("peter"));
		System.out.println(namesList.size());
		System.out.println(namesList.get(3));
		
//		namesList.clear();
		System.out.println(namesList);
		
		//old approach
		
		Iterator<String> itr = namesList.iterator();
		
//		while(itr.hasNext()) {
//			String name = itr.next();
//			System.out.println(name);
//		}
		
		for(String name:namesList) {
			System.out.println(name);
		}
		
	}

}
