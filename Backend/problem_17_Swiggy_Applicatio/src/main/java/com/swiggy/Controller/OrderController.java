package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Order;
import com.swiggy.service.OrderService;

@RestController
public class OrderController {
      
	@Autowired
	private OrderService orderService;

	@PostMapping(value = "/orders")
	public ResponseEntity<Order> addOrder(Order order){
		return new ResponseEntity<Order>(orderService.addOrder(order),HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/orders")
	public ResponseEntity<List<Order>> viewAllOrder(){
		return new ResponseEntity<List<Order>>(orderService.ViewAllOrder(),HttpStatus.OK);
	}
	
	
	
	
}
