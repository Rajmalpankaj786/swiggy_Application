package com.swiggy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurant_table")
public class Restaurant {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer restaurantId;
     
     @Column(name = "resturant_name")
     private String name;
     
     @Column(name = "resturant_address")
     private String address;

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Restaurant(Integer restaurantId, String name, String address) {
		super();
		this.restaurantId = restaurantId;
		this.name = name;
		this.address = address;
	}

	public Restaurant() {
		super();
	}

	
     
     
     
}
