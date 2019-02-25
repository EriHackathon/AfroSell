package com.erihackton.shopping.exceptions;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ProductExceptionController extends  ResponseEntityExceptionHandler{
	
	@ExceptionHandler(value=ProductNotFoundException.class)
			
    public ResponseEntity<Object> exception(Exception ex,WebRequest request){
		ErrorMessage errorMessage= new ErrorMessage(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(errorMessage,new HttpHeaders(),HttpStatus.INTERNAL_SERVER_ERROR);
	
	}

}
