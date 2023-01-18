package com.demo.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class GreetMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("context3.xml");

		GreetService greetService = (GreetService)ctx.getBean("greetBean");

		greetService.greet();

	}

}
