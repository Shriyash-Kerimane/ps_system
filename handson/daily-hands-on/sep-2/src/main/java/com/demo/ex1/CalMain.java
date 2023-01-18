package com.demo.ex1;

public class CalMain {

	public static void main(String[] args) {
		ICalculation call=(x,y)->(x+y);
		ICalculation call1=(x,y)->(x-y);
		ICalculation call2=(x,y)->(x*y);
		ICalculation call3=(x,y)->(x/y);
		
		double result=call.doOperation(4, 5);
		double result1=call1.doOperation(4, 5);
		double result2=call2.doOperation(4, 5);
		double result3=call3.doOperation(10, 5);
		
		System.out.println(result);
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		
		
	}

}
