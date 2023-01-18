package com.demo.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CollectionsUtil {

	public static void main(String[] args) {
		List<String> namesList = new ArrayList<>();
		namesList.add("john");
		namesList.add("joh");
		namesList.add("jo");
		namesList.add("j");
		
		List<String> immutableList=Collections.unmodifiableList(namesList);
		System.out.println(namesList);
		immutableList.add("newton");
		
//		List<String> syschList=Collections.synchronizedList(namesList);
		
		

	}

}
