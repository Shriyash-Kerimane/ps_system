package com.demo.maps;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
	public static void main(String[] args) {
		Map<Integer, String> mobileData=new HashMap<>();
		
		mobileData.put(38765432, "John");
		mobileData.put(68765433, "Nikola");
		mobileData.put(18765434, "Tesla");
		mobileData.put(58765435, "Newton");
		mobileData.put(28765436, "Dalton");
		mobileData.put(48765437, "Kelvin");
		
		System.out.println(mobileData);
		System.out.println(mobileData.get(98765433));
		mobileData.remove(98765435);
		System.out.println(mobileData);
		
		Set<Integer> keys=mobileData.keySet();
		
		for(Integer key:keys) {
			System.out.println(key+"----->"+mobileData.get(key));
		}
		if(mobileData.containsKey(98765433)) {
			System.out.println("mobile data exists");
		}
		else {
			System.out.println("miobile data does not exists");
		}
		
	}
	

}
