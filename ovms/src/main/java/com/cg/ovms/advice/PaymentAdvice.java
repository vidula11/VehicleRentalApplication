package com.cg.ovms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ovms.dto.ErrorMessageDto;
import com.cg.ovms.exception.PaymentDoneForBookingException;
import com.cg.ovms.exception.PaymentIdException;
import com.cg.ovms.exception.ValidatePaymentException;

@RestControllerAdvice
public class PaymentAdvice {
	

	@ExceptionHandler(PaymentIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handlePaymentIdException(PaymentIdException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	
	
	@ExceptionHandler(PaymentDoneForBookingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handlePaymentDoneForBookingException(PaymentDoneForBookingException exception) {
		return new ErrorMessageDto(exception.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	
	
	
	@ExceptionHandler(ValidatePaymentException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidatePaymentException(ValidatePaymentException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}

}
