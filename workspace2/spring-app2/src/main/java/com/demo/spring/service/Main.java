package com.demo.spring.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.spring.GreetService;

public class Main {
	public static void main(String[] args) {
		
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

		EmployeeService service = (EmployeeService ) ctx.getBean("employeeService");

		System.out.println( service.registerEmp(100, "Shriyash","Kerimane", 100000));
	}
}
