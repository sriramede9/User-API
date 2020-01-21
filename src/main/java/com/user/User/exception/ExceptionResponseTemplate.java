package com.user.User.exception;

import java.util.Date;

public class ExceptionResponseTemplate {

	private Date timeStamp;
	private String message;
	private String details;

	public ExceptionResponseTemplate() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExceptionResponseTemplate(Date timeStamp, String message, String details) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.details = details;
	}

	@Override
	public String toString() {
		return "ExceptionResponseTemplate [message=" + message + ", details=" + details + "]";
	}

}
