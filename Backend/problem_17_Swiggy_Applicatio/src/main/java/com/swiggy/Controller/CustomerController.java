package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Customer;
import com.swiggy.service.CustomerService;

@RestController
public class CustomerController {
       
	@Autowired
	private CustomerService customerService;
	
	@PostMapping(value = "/customers")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.addCustomer(customer),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/customers")
	public ResponseEntity<List<Customer>> viewAllCustomer(){
		return new ResponseEntity<List<Customer>>(customerService.ViewAllCustomer(), HttpStatus.OK);
	}
	
	
}
