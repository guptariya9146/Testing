package com.nagarro.user.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DataValidationExceptionHandler extends ResponseEntityExceptionHandler{
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(DataValidationException.class)
    private ResponseEntity<Object> handleRecordNotFoundExceptions(DataValidationException ex)
    {
		String error=ex.getMessage();
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
    }
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler(UserNotFoundException.class)
    private ResponseEntity<Object> handleUserNotFoundExceptions(UserNotFoundException ex)
    {
		String error=ex.getMessage();
		return new ResponseEntity(error, HttpStatus.NOT_FOUND);
		
    }
	
	@ExceptionHandler(value = UserAlreadyExistException.class)
	public ResponseEntity<Object> handleUserAlreadyExistException(UserAlreadyExistException ex) {
		
		String error=ex.getMessage();
		return new ResponseEntity<>(error, HttpStatus.CONFLICT);
	}
	
	@ExceptionHandler(value = BadRequestException.class)
	public ResponseEntity<Object> handleBadRequestexception(BadRequestException ex) {
		
		String error=ex.getMessage();
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
	

	
	
	
	

}
