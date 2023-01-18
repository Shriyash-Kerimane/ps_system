package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MessageRestController {

	@Autowired
	RestTemplate template;
	
	@GetMapping(path="/greet")
	public String greet() {
		String hello=template.getForObject("http://localhost:8080/hello", String.class);
		String world=template.getForObject("http://localhost:8081/world", String.class);
		
		return hello + " " + world;
	}
}
