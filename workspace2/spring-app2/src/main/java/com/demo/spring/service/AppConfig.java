package com.demo.spring.service;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.demo.spring.entity","com.demo.spring.service"})
public class AppConfig {
	
}
