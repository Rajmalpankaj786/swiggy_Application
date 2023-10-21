package com.swiggy.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/lombok")
//@Slf4j
public class LombokLoggingController {
    Logger logger = LoggerFactory.getLogger(LombokLoggingController.class);
	@GetMapping(value = "/logging")
	public ResponseEntity<String> getLoggingmsg(){
		logger.error("This message for error side");
		logger.warn("This message for debug side");
		logger.info("This message for debug side");
		logger.debug("This message for debug side");
		logger.trace("This message for debug side");
		
return new ResponseEntity<String>("hello moto" , HttpStatus.OK);
//
//
	}
	}
