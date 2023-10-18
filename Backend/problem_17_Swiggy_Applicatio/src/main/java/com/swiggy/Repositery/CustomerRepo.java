package com.swiggy.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.swiggy.Model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

	 @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email = :email")
	    boolean existsByEmail(@Param("email") String email);	
	
	
	
	
	
	
}
