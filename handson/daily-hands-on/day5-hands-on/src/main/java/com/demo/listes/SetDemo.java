package com.demo.listes;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetDemo {

	public static void main(String[] args) {
		Set<String> nameSet=new HashSet<>();
		
		nameSet.add("John");
		nameSet.add("peter");
		nameSet.add("Jack");
		nameSet.add("srinivas");
		nameSet.add("peterson");
		nameSet.remove(2);
		System.out.println(nameSet);
		System.out.println(nameSet.contains("peter"));
		System.out.println(nameSet.size());
		
		
//		namesList.clear();
		System.out.println(nameSet);
		
		//old approach
		
		Iterator<String> itr = nameSet.iterator();
		
//		while(itr.hasNext()) {
//			String name = itr.next();
//			System.out.println(name);
//		}
		
		for(String name:nameSet) {
			System.out.println(name);
		}
		
	}

}
