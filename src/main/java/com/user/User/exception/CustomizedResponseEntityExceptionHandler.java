package com.user.User.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		// creating a customized body
		ExceptionResponseTemplate rt = new ExceptionResponseTemplate(new Date(), ex.getMessage(),
				request.getDescription(false));

		// return super.handleExceptionInternal(ex, body, headers, status, request);
		return new ResponseEntity(rt, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NosuchUserFoundException.class)
	protected ResponseEntity<Object> handleExceptionNosuchUser(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		// creating a customized body
		ExceptionResponseTemplate rt = new ExceptionResponseTemplate(new Date(), ex.getMessage(),
				request.getDescription(false));

		// return super.handleExceptionInternal(ex, body, headers, status, request);
		return new ResponseEntity(rt, HttpStatus.NOT_FOUND);
	}
}
