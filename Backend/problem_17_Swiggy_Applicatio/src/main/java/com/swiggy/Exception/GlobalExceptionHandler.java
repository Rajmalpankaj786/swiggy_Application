package com.swiggy.Exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

//	@ExceptionHandler(DuplicateValueException.class)
//	public ResponseEntity<ErrorDetails> duplicateValueExceptionHandler (DuplicateValueException dve) {
//		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), dve.getMessage());
//		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
//	}


	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorDetails> customerAlreadyExistsExceptionHandler (CustomerAlreadyExistsException manv) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), manv.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}
	

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorDetails> notFoundExceptionHandler(NotFoundException unf) {
		ErrorDetails ed = new ErrorDetails(LocalDateTime.now(), unf.getMessage());
		return new ResponseEntity<ErrorDetails>(ed, HttpStatus.BAD_REQUEST);
	}

}
