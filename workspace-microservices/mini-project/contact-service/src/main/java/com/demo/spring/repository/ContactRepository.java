package com.demo.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
	
	
	@Query("select c from Contact c where c.userId=:userId")
	public List<Contact> findAllByUserId(Integer userId);
	
	@Query("select e from Contact e where e.userId=:userId and e.contactTag=:contactTag")
	public List<Contact> findContactsOfUserByTag(String contactTag, Integer userId);
	
	@Query("delete from Contact c where c.userId=:userId")
	@Modifying
	@Transactional
	public void deleteAllByUserId(Integer userId);	
	
	@Query("update Contact c set c.email=:email where c.userId=:userId")
	@Modifying
	@Transactional
	public void updateContactById(Integer userId, String email);	
	
	public boolean existsByUserId(Integer userId);
	
}
