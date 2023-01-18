package com.demo.ex1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatMapDemo {

	public static void main(String[] args) {

		Fruit apple = new Fruit("apple", 45);
		Fruit orange = new Fruit("orange", 60);
		Fruit banana = new Fruit("banana", 56);
		Fruit pear = new Fruit("pear", 54);
		Fruit guava = new Fruit("guava", 30);

		List<Fruit> basket1 = Arrays.asList(apple, banana);
		List<Fruit> basket2 = Arrays.asList(apple, orange);
		List<Fruit> basket3 = Arrays.asList(orange, pear);
		List<Fruit> basket4 = Arrays.asList(pear, banana);

		List<List<Fruit>> fruitsContainer = Arrays.asList(basket1, basket2, basket3, basket4);

		System.out.println(fruitsContainer.stream().flatMap(l->l.stream()).collect(Collectors.toList()));
		
		//set to list
		Set<Fruit> fruitsSet=new HashSet<>();
		fruitsSet.add(apple);
		fruitsSet.add(banana);
		fruitsSet.add(guava);
		fruitsSet.add(pear);
		fruitsSet.add(orange);
		
		System.out.println(fruitsSet.stream().collect(Collectors.toList()));
		Map<Character, Fruit> map = new HashMap<>();
		System.out.println(fruitsSet.stream().collect(Collectors.toMap(item->item.getName().charAt(0), item->item)));
		
		
		
	}

}
