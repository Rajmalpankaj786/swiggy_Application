package com.swiggy.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException(String msg) {
    	super(msg);
    }
    public NotFoundException() {
    	super();
    }
}
