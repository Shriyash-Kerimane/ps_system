package com.demo.maps;

import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class TreeMapDemo {

	public static void main(String[] args) {
		SortedMap<Integer, String> mobileData = new TreeMap<>();

		mobileData.put(98765432, "John");
		mobileData.put(98765433, "Nikola");
		mobileData.put(98765434, "Tesla");
		mobileData.put(98765435, "Newton");
		mobileData.put(98765436, "Dalton");
		mobileData.put(98765437, "Kelvin");

		System.out.println(mobileData);
		System.out.println(mobileData.get(98765433));
		mobileData.remove(98765435);
		System.out.println(mobileData);

		Set<Integer> keys = mobileData.keySet();

		for (Integer key : keys) {
			System.out.println(key + "----->" + mobileData.get(key));
		}

	}

}
