package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Order;

import com.swiggy.service.OrderService;

@RestController
public class OrderController {
      
	@Autowired
	private OrderService orderService;
	//private DeliveryPartnerSevice deliveryPartnerSevice;

	@PostMapping(value = "/orders")
	public ResponseEntity<Order> addOrder(@RequestBody Order order){
		return new ResponseEntity<Order>(orderService.placeOrder(order),HttpStatus.CREATED);
		
	}
	
	@GetMapping(value = "/orders")
	public ResponseEntity<List<Order>> viewAllOrder(){
		return new ResponseEntity<List<Order>>(orderService.ViewAllOrder(),HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/orders/{id}")
	public ResponseEntity<Order> deleteOrder(@PathVariable Integer id){
		return new ResponseEntity<Order>(orderService.deleteOrder(id) ,HttpStatus.OK);
	}
	
	@PostMapping(value = "/orders/{id}")
	public ResponseEntity<Order> assignDeliveryPartner(@RequestBody Order order , @PathVariable Integer id){
		return new ResponseEntity<Order>(orderService.assignDeliveryPartner(order, id),HttpStatus.OK);
	}
	
	
	
}
