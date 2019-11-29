package com.cognizant.authenticationservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.authenticationservice.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	@Query("select u from User  u where u.usr_id = ?1")
	 User findByUsername( String name);
	

	
	
}
