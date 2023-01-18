package com.demo.application;

public class Employee {
	private int empid;
	private String name;
	private Address address;
	private double salary;
	public Employee(int empid, String name, Address address, double salary) {
		this.empid = empid;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	

}
