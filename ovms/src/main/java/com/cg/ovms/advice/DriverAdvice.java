package com.cg.ovms.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.ovms.dto.ErrorMessageDto;
import com.cg.ovms.exception.DriverIdException;
import com.cg.ovms.exception.ValidateDriverException;
@RestControllerAdvice
public class DriverAdvice {

	@ExceptionHandler(DriverIdException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorMessageDto handleDriverIdException(DriverIdException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.NOT_FOUND.toString());
		
	}

	@ExceptionHandler(ValidateDriverException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorMessageDto handleValidateDriverException(ValidateDriverException ex) {
		return new ErrorMessageDto(ex.getMessage(),HttpStatus.BAD_REQUEST.toString());
		
	}
}
