package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Customer;
import com.swiggy.Model.Order;

import com.swiggy.service.OrderService;

@RestController
@CrossOrigin(origins = "*")
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
	
	@PutMapping(value = "/orders/{orderId}/{deliveryPartnerId}")
	public ResponseEntity<Order> assignDeliveryPartner(@PathVariable Integer orderId, @PathVariable Integer deliveryPartnerId){
		return new ResponseEntity<Order>(orderService.assignDeliveryPartner(orderId, deliveryPartnerId),HttpStatus.OK);
	}
	@GetMapping(value = "/orders/{pageNo}/{recordPerPage}")
	public ResponseEntity<List<Order> > getCustomerPageWise(@PathVariable Integer pageNo , @PathVariable Integer recordPerPage){
		return new ResponseEntity<List<Order>>(orderService.getOrderPageWise(pageNo, recordPerPage), HttpStatus.OK);
	}
	
	
}
