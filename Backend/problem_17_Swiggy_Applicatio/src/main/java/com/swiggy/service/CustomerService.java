package com.swiggy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiggy.Exception.CustomerAlreadyExistsException;
import com.swiggy.Exception.NotFoundException;
import com.swiggy.Model.Customer;
import com.swiggy.Repositery.CustomerRepo;

@Service
public class CustomerService {
     
	private CustomerRepo customerRepo;

	public CustomerService(CustomerRepo customerRepo) {
		super();
		this.customerRepo = customerRepo;
	}
	
	public Customer addCustomer(Customer customer) {
		if (customerRepo.existsByEmail(customer.getEmail())) {
	       throw new NotFoundException("customer email already exist");
	    }
		return customerRepo.save(customer);
	}
	
	public List<Customer> ViewAllCustomer(){
		return customerRepo.findAll();
	}
	
	
}
