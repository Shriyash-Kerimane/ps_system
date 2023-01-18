package com.demo.exceptions;

public class Practice {

	public static void main(String[] args) {
		try{
			String str = "some name";
		int num = Integer.parseInt(str);
		}catch(NumberFormatException e) {
//			System.out.println(e.getMessage());
			e.printStackTrace();
		};
		

	}

}
