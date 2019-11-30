package com.cognizant.billpaymentservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.billpaymentservice.model.User;



public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query(value="select * from user  where us_usID=:id", nativeQuery=true)
	public User findByIdName(@Param (value="id") String userId);
	
	@Query(value="select * from user  where us_usID=:id", nativeQuery=true)
	public Optional<User> findByname(@Param (value="id") String userId);



}
