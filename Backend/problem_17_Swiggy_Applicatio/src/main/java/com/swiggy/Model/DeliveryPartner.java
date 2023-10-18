package com.swiggy.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Pattern.Flag;

@Entity
@Table(name = "Deliver_Partner_table")
public class DeliveryPartner {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer deliveryPartnerId;
	
	@Column(name = "DP_name")
	private String name; 
	
	@Column(name = "DP_PhoneNo")
	@Pattern(regexp = "[6-9][0-9]{9}" , flags = Flag.CASE_INSENSITIVE)
	private String phoneNumber;

	public Integer getDeliveryPartnerId() {
		return deliveryPartnerId;
	}

	public void setDeliveryPartnerId(Integer deliveryPartnerId) {
		this.deliveryPartnerId = deliveryPartnerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public DeliveryPartner(Integer deliveryPartnerId, String name,
			@Pattern(regexp = "[6-9][0-9]{9}", flags = Flag.CASE_INSENSITIVE) String phoneNumber) {
		super();
		this.deliveryPartnerId = deliveryPartnerId;
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	public DeliveryPartner() {
		super();
	}

	
	
	
}
