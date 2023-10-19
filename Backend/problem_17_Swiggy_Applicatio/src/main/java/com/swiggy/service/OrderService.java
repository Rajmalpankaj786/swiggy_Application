package com.swiggy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.swiggy.Exception.NotFoundException;
import com.swiggy.Model.DeliveryPartner;
import com.swiggy.Model.Order;
import com.swiggy.Repositery.DeliveryPartnersRepo;
import com.swiggy.Repositery.OrderRepo;

@Service
public class OrderService {
	@Autowired
	private OrderRepo orderRepo;
	@Autowired
	private DeliveryPartnersRepo deliveryPartnersRepo;

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

	public Order assignDeliveryPartner(Integer orderId, Integer id) {
		Optional<DeliveryPartner> d1 = deliveryPartnersRepo.findById(id);
		Optional<Order> order = orderRepo.findById(orderId);
		
		if(order.isPresent()) {
		Order o1 = 	order.get();
			
			if (d1.isPresent() ) {
				o1.setDeliveryPartnerId(id);
				o1.setOrderStatus("delivered");
				orderRepo.save(o1);
				return o1;
			}
			else {
				throw new NotFoundException("DeliveryPartner id : " + id + " not exist. ");
			}
		}

		throw new NotFoundException("order id : " + id + " not exist. ");


	}
	
	public List<Order> getOrderPageWise(Integer pageNo , Integer recordPerPage){
		Pageable pageable = PageRequest.of(pageNo, recordPerPage);
		Page<Order> page = orderRepo.findAll(pageable);
		if(page.hasContent()) {
			return page.getContent();
		}
		throw new NotFoundException("No Records for the current page : " +pageNo);
		
		}

}
