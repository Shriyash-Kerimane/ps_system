package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	private EmpDao dao;	
	
	public String registerEmp(int id, String name, String city, double sal) {
		
		String response = dao.save(new Employee(id, name, city, sal));
	
		return response;	
	}
}
