package com.swiggy.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.swiggy.Exception.NotFoundException;
import com.swiggy.Model.Order;

import com.swiggy.Repositery.OrderRepo;

@Service
public class OrderService {

	private OrderRepo orderRepo;
	//private DeliveryPartnersRepo deliveryPartnersRepo;

	

	public OrderService(OrderRepo orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	public List<Order> ViewAllOrder() {
		return orderRepo.findAll();
	}

	public Order placeOrder(Order order) {
		return orderRepo.save(order);
	}

	public Order deleteOrder(Integer id) {
		Optional<Order> optionalOrder = orderRepo.findById(id);
		if (optionalOrder.isEmpty()) {
			throw new NotFoundException("Order with ID " + id + " not found");
		}
		Order order = optionalOrder.get();
		orderRepo.deleteById(id);
		return order;

	}

	public Order assignDeliveryPartner(Order order, Integer id) {
//		Optional<DeliveryPartner> d1 = deliveryPartnersRepo.findById(id);
//		if(d1.isPresent()) {
//			d1.get();
//			order.setDeliveryPartnerId(id);
//		    orderRepo.save(order);
//		    return order;
//		}
		// throw new NotFoundException("DeliveryPartner id : "+id+" not exist. ");

		order.setDeliveryPartnerId(id);
		orderRepo.save(order);
		order.setOrderStatus("delivered");
		orderRepo.save(order);
		return order;
	}

}
