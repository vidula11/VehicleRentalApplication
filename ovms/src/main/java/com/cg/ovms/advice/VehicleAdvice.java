package com.cg.ovms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.cg.ovms.dto.ErrorMessageDto;
import com.cg.ovms.exception.ValidateVehicleException;
import com.cg.ovms.exception.VehicleIdException;


@RestControllerAdvice
public class VehicleAdvice {
	
	@ExceptionHandler(VehicleIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleVehicleIdException(VehicleIdException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}
	

	@ExceptionHandler(ValidateVehicleException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateVehicleException(ValidateVehicleException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}

}
