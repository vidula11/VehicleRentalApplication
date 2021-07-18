package com.cg.ovms.advice;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ovms.dto.ErrorMessageDto;
import com.cg.ovms.exception.CustomerIdException;
import com.cg.ovms.exception.ValidateCustomerException;

@RestControllerAdvice
public class CustomerAdvice {
	
	@ExceptionHandler(CustomerIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerIdException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}

	@ExceptionHandler(ValidateCustomerException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateCustomerException(ValidateCustomerException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}
}
