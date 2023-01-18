package com.demo.spring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WorldRestController {

	@GetMapping(path="/world")
	public String getWorld() {
		return "world";
	}
}
