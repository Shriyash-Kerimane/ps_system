package com.demo.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main1 {

	public static void main(String[] args) {
		List<Emp> db = new ArrayList<>();
		db.add(new Emp(100, "Alpha", "Hyderabad", 35000D));
		db.add(new Emp(101, "Beta", "Banglore", 60000D));
		db.add(new Emp(102, "Gamma", "Mumbai", 35000D));
		db.add(new Emp(103, "Delta", "Hyderabad", 20000D));
		db.add(new Emp(104, "Epsilon", "Banglore", 35000D));
		db.add(new Emp(105, "Zeta", "Mumbai", 50000D));
		db.add(new Emp(106, "Eta", "Hyderabad", 10000D));
		db.add(new Emp(107, "Theta", "Banglore", 35000D));
		db.add(new Emp(108, "Iota", "Chennai", 100000D));
		db.add(new Emp(109, "Kappa", "Mumbai", 35000D));
		
		System.out.println("1");
		db.stream().filter(x->x.getCity().equals("Chennai")||x.getCity().equals("Hyderabad")).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("2");
		db.stream().filter(x->x.getSalary()>35000).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("3");
		db.stream().filter(x->x.getSalary()<35000).peek(x->x.setCity("Pune")).peek(x->x.setSalary(x.getSalary()+5000)).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("4");
		db.stream().map(x->x.getSalary()/12).collect(Collectors.toList()).forEach(System.out::println);
		
//		map(x->{x.setSalary(x.getSalary()+5000;return x})
		
		System.out.println("5");
		db.stream().peek(x->x.setSalary(x.getSalary()+1000)).collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println(db);
		
		

		

		

	}

}
