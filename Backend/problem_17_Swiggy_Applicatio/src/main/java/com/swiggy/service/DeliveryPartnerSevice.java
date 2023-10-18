package com.swiggy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.swiggy.Model.DeliveryPartner;
import com.swiggy.Repositery.DeliveryPartnersRepo;

@Service
public class DeliveryPartnerSevice {
 
	private DeliveryPartnersRepo deliveryPartnersRepo;
	
	
	
	public DeliveryPartnerSevice(DeliveryPartnersRepo deliveryPartnersRepo) {
		super();
		this.deliveryPartnersRepo = deliveryPartnersRepo;
	}
	public DeliveryPartner addDeliveryPartner(DeliveryPartner deliveryPartner) {
		return deliveryPartnersRepo.save(deliveryPartner);
	}
	public List<DeliveryPartner> ViewAllDeliveryPartner(){
		return deliveryPartnersRepo.findAll();
	}
	
	
} 
