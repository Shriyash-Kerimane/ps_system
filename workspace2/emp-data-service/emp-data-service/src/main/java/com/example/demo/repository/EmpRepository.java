package com.example.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.spring.entity.Emp;

public interface EmpRepository extends JpaRepository<Emp,Integer> {
	
	@Query("Update Emp e set e.salary=:salary where e.empId=:id")
	@Modifying
	@Transactional
	public void updateSalary(int id,double salary);

}
