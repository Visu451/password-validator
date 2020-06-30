package com.visu.password.exception;

import java.util.Date;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseBody
public class CredentialValidationHandler extends ResponseEntityExceptionHandler {
	
	private final String BAD_REQUEST = "The passowrd must be between 5 and 12 characters in length, consists of a mixture of lowercase letters and numerical digits only, with at least one of each, and must not contain any sequence of characters immediately followed by the same sequence.";
	  @SuppressWarnings({ "unchecked", "rawtypes" })
	  @Override
	  protected ResponseEntity<Object>
	  handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders
	  headers, HttpStatus status, WebRequest request) { ErrorDetails errorDetails =
	  new ErrorDetails(new Date(), "Password validation failed.", BAD_REQUEST); 
	  return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST); }
	 

}
