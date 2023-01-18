package com.demo.entity;
import java.util.List;

public interface CustomerDao {

	public Customer findCustomerById(int id);

	public String save(Customer c);

	public String update(Customer c);

	public String delete(int customerId);

	public List<Customer> listAll();

}
