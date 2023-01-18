package com.demo.spring.service;

import org.springframework.stereotype.Component;

import com.demo.spring.entity.Employee;

@Component
public class EmpDaoMockImpl implements EmpDao {

	@Override
	public String save(Employee e) {
		System.out.println("Emp Saved");
		return "saved";
	}

}
