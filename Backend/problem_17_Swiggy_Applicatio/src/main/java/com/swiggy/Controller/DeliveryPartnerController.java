package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.DeliveryPartner;
import com.swiggy.service.DeliveryPartnerSevice;

@RestController
public class DeliveryPartnerController {
   
	@Autowired
	private DeliveryPartnerSevice deliveryPartnerSevice;
	
	@PostMapping(value = "/dp")
	public ResponseEntity<DeliveryPartner> addDeliveryPartner(@RequestBody DeliveryPartner deliveryPartner){
		return new ResponseEntity<DeliveryPartner>(deliveryPartnerSevice.addDeliveryPartner(deliveryPartner),HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/dp")
	public ResponseEntity<List<DeliveryPartner>> viewAllDeliveryPartner(){
		return new ResponseEntity<List<DeliveryPartner>>(deliveryPartnerSevice.ViewAllDeliveryPartner(),HttpStatus.OK);
	}
	
	
}
