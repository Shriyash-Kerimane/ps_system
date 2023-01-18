package com.demo.application;

public class EmpDAO {
	public String save(Employee emp) {
		System.out.println("Emp with saved id "+emp);
		return "Emp saved";
	}

}
