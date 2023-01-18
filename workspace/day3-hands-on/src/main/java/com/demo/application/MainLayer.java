package com.demo.application;

public class MainLayer {

	public static void main(String[] args) {
//		ServiceLayer service=new ServiceLayer();
//		String result=service.compose("Assignment","Panic");
//		System.out.println(result);
		EmployeeService service=new EmployeeService();
		String result = service.registerEmployee(10, "jack", 10000L, "101A", "Bangalore", 500001);
		System.out.println(result);
		

	}

}
