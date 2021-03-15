package com.nse.group.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AppExceptionHandler {

	
	
	@ExceptionHandler(MemberAlreadyExistsException.class)
	public ResponseEntity<String> memberAlreadyExists(MemberAlreadyExistsException ex){
		
		return new ResponseEntity<String>(ex.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MemberNotExistsException.class)
	public ResponseEntity<String> memberNotExists(MemberNotExistsException ex){
		
		return new ResponseEntity<String>(ex.getMessage() , HttpStatus.BAD_REQUEST);
	}
	
	
}
