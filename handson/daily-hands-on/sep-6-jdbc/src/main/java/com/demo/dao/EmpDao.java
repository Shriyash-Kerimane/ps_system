package com.demo.dao;

import java.util.List;

import com.demo.exceptions.EmpExitsException;
import com.demo.exceptions.EmpNotFoundException;
import com.demo.jdbc.Emp;

public interface EmpDao {
	
	public Emp findById(Integer id) throws EmpNotFoundException;
	public String save(Emp e) throws EmpExitsException;
	public String delete(Integer id) throws EmpNotFoundException;
	public String update(Emp e) throws EmpNotFoundException;
	public List<Emp> findAll();

}
