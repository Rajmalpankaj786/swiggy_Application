package com.swiggy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.swiggy.Exception.NotFoundException;
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
	
	public List<Restaurant> getRestaurantPageWise(Integer pageNo , Integer recordPerPage){
		Pageable pageable = PageRequest.of(pageNo, recordPerPage);
		Page<Restaurant> page = restaurantRepo.findAll(pageable);
		if(page.hasContent()) {
			return page.getContent();
		}
		throw new NotFoundException("No Records for the current page : " +pageNo);
		
		}
}
