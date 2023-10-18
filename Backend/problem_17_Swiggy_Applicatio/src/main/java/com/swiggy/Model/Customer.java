package com.swiggy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "customer_table")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@Column(name = "customer_name")
	private String name;

	@Column(name = "customer_email")
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
	private String email;

	@Column(name = "customer_address")
	private String address;

	public int getCustomerId() {
		return customerId;
	}

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	

	public Customer(Integer customerId, String name, String email, String address) {
		super();
		this.customerId = customerId;
		this.name = name;
		this.email = email;
		this.address = address;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}


	public Customer() {
		super();
	}

	
	
}
