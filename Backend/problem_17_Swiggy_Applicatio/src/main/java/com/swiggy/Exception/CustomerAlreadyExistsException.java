package com.swiggy.Exception;

public class CustomerAlreadyExistsException extends RuntimeException{

	public CustomerAlreadyExistsException(String msg) {
    	super(msg);
    }
    public CustomerAlreadyExistsException() {
    	super();
    }
}
