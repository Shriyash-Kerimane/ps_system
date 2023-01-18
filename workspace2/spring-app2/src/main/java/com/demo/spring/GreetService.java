package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class GreetService {
	
	@Autowired
	@Qualifier("goodMorning")
	private Greet greet;

	public void greet() {
		System.out.println(greet.greetMessage());
	}
}