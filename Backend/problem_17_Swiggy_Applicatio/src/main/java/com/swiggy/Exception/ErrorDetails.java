package com.swiggy.Exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private LocalDateTime timestamp;
	private String message;

	public ErrorDetails() {
	}





	public ErrorDetails(LocalDateTime timestamp, String message) {
		super();
		this.timestamp = timestamp;
		this.message = message;

	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


}
