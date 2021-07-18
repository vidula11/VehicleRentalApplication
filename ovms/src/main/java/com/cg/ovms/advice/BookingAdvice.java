package com.cg.ovms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.ovms.dto.ErrorMessageDto;
import com.cg.ovms.exception.BookingAlreadyExistsException;
import com.cg.ovms.exception.BookingDateException;
import com.cg.ovms.exception.BookingIdException;
import com.cg.ovms.exception.CustomerNotFoundException;
import com.cg.ovms.exception.ValidateBookingException;
import com.cg.ovms.exception.VehicleNotFoundException;

@RestControllerAdvice
public class BookingAdvice {
	
	@ExceptionHandler(BookingIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleBookingIdException(BookingIdException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}

	@ExceptionHandler(ValidateBookingException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateBookingException(ValidateBookingException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}

	@ExceptionHandler(BookingAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateBookingAlreadyExistsException(BookingAlreadyExistsException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}
	@ExceptionHandler(BookingDateException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateBookingDateExistsException(BookingDateException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
	}
	@ExceptionHandler(VehicleNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleVehicleException(VehicleNotFoundException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleCustomerException(CustomerNotFoundException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}

}
