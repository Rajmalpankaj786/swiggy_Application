package com.swiggy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiggy.Model.Restaurant;
import com.swiggy.Repositery.RestaurantRepo;

@Service
public class RestautantService {
	private RestaurantRepo restaurantRepo;

	public RestautantService(RestaurantRepo restaurantRepo) {
		super();
		this.restaurantRepo = restaurantRepo;
	}

	public Restaurant addRestaurant(Restaurant restaurant) {
		return restaurantRepo.save(restaurant);
	}

	public List<Restaurant> viewAllRestaurant() {
		return restaurantRepo.findAll();
	}
}
