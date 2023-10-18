package com.swiggy.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import com.swiggy.Model.Restaurant;


public interface RestaurantRepo extends JpaRepository<Restaurant,Integer>{

}
