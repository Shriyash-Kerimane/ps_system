package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {

		ApplicationContext ctx = new ClassPathXmlApplicationContext("context2.xml");

		Emp emp = ctx.getBean(Emp.class, "emp");

		System.out.println("Employee Id : " + emp.getEmpId());

		System.out.println(emp.getName().getFirstName() + " " + emp.getName().getLastName());

		System.out.println("City : " + emp.getAddress().getCity() );

		System.out.println("Salary : " + emp.getSalary());

	}
}
