package com.swiggy.Model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "order_table")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer orderId;
	@Column(nullable = false)
	@NotNull(message = "customer Id not be null")
	private Integer customerId;
	@Column(nullable = false)
	@NotNull(message = "restaurantId not be null")
	private Integer restaurantId;
	@Column(nullable = true)
	private Integer deliveryPartnerId;

	private List<String> menuItems;

	private String orderStatus;

	public Integer getOrderId() {
		return orderId;
	}
 
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(Integer deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public List<String> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(List<String> menuItems) {
		this.menuItems = menuItems;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(Integer orderId, Integer customerId, Integer restaurantId, Integer deliveryPartnerId,
			List<String> menuItems, String orderStatus) {
		super();
		this.orderId = orderId;
		this.customerId = customerId;
		this.restaurantId = restaurantId;
		this.deliveryPartnerId = deliveryPartnerId;
		this.menuItems = menuItems;
		this.orderStatus = orderStatus;
	}

	public Order() {
		super();
	}

}
