package com.swiggy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiggy.Model.Order;
import com.swiggy.Repositery.OrderRepo;



@Service
public class OrderService {
     
	private OrderRepo orderRepo;

	
	public OrderService(OrderRepo orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	public  Order addOrder( Order customer) {
		return orderRepo.save(customer);
	}
	
	public List<Order> ViewAllOrder(){
		return orderRepo.findAll();
	}
	
	
}
