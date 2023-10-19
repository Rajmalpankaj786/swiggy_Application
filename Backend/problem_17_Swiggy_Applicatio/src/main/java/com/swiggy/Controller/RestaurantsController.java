package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Order;
import com.swiggy.Model.Restaurant;
import com.swiggy.service.RestautantService;

@RestController
@CrossOrigin(origins = "*")
public class RestaurantsController {
     @Autowired
     private RestautantService restautantService;
     
     @PostMapping(value = "/restaurants")
     public ResponseEntity<Restaurant> addRestaurant(@RequestBody Restaurant restaurant){
    	 return new ResponseEntity<Restaurant>(restautantService.addRestaurant(restaurant), HttpStatus.CREATED);
     }
     
     @GetMapping(value = "/restaurants")
     public ResponseEntity<List<Restaurant>> viewAllRestaurant(){
    	 return new ResponseEntity<List<Restaurant>>(restautantService.viewAllRestaurant(),HttpStatus.OK);
     }
     @GetMapping(value = "/restaurants/{pageNo}/{recordPerPage}")
 	public ResponseEntity<List<Restaurant> > getRestaurantPageWise(@PathVariable Integer pageNo , @PathVariable Integer recordPerPage){
 		return new ResponseEntity<List<Restaurant>>( restautantService.getRestaurantPageWise(pageNo, recordPerPage), HttpStatus.OK);
 	}
}
