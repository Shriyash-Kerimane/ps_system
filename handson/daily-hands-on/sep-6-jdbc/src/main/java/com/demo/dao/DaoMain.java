package com.demo.dao;

import java.util.ArrayList;
import java.util.List;

import com.demo.jdbc.Emp;

public class DaoMain {
	public static void main(String[] args) throws Exception {
		List<Emp> list = new ArrayList<>();
		EmpDao dao = new EmpDaoJdbcImpl();
		
		Emp e = dao.findById(102);
		System.out.println(e.getName()+" "+e.getSalary());
		
//		Emp e2 = new Emp(109,"kappa","sagar",99000.0);
//		System.out.println(dao.save(e2));
		
//		System.out.println(dao.delete(109));
		list = dao.findAll();
		for(Emp emp : list) {
			System.out.println("( "+emp.getEmpId()+" "+emp.getName()+" "+emp.getCity()+" "+emp.getSalary()+" )");
		}
		
	}
}
