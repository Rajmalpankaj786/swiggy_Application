package com.swiggy.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swiggy.Model.Customer;
import com.swiggy.Model.DeliveryPartner;
import com.swiggy.service.DeliveryPartnerSevice;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/deliveryPartner")
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
	
	@GetMapping(value = "/dp/{pageNo}/{recordPerPage}")
	public ResponseEntity<List<DeliveryPartner> > getDeliveryPartnerPageWise(@PathVariable Integer pageNo , @PathVariable Integer recordPerPage){
		return new ResponseEntity<List<DeliveryPartner>>(deliveryPartnerSevice.getDeliveryPartnerPageWise(pageNo, recordPerPage), HttpStatus.OK);
	}
	
}
