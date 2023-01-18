package com.demo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("update User c set c.userName=:userName where c.userId=:userId")
	@Modifying
	@Transactional
	public void updateUserById(Integer userId, String userName);
}
