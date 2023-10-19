package com.swiggy.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.swiggy.Exception.NotFoundException;
import com.swiggy.Model.Customer;
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
	
	public List<DeliveryPartner> getDeliveryPartnerPageWise(Integer pageNo , Integer recordPerPage){
		Pageable pageable = PageRequest.of(pageNo, recordPerPage);
		Page<DeliveryPartner> page = deliveryPartnersRepo.findAll(pageable);
		if(page.hasContent()) {
			return page.getContent();
		}
		throw new NotFoundException("No Records for the current page : " +pageNo);
		
		}
	
	
} 
