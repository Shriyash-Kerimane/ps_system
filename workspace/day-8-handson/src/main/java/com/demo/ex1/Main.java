package com.demo.ex1;

public class Main {

	public static void main(String[] args) {
		
		Greeter goodNight=(name)->"Good Night to "+name;
		
		System.out.println(goodNight.getGreet("SK"));
		
		Concat doconcat=(s1,s2)->s1+s2;
		System.out.println(doconcat.getConcat("Hello", "World"));

	}

}

//class GoodMorning implements Concat {
//
//	@Override
//	public String getGreet(String name) {
//
//		return "Good Morning to " + name;
//	}
//
//}