package com.example.demo.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.dto.response.ErrorResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyException( CustomerAlreadyExistsException ex){
		ErrorResponseDto eRes = new ErrorResponseDto();
		eRes.setStatus(HttpStatus.CONFLICT.value());
		eRes.setMessage(ex.getMessage());
		eRes.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.CONFLICT).body(eRes);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponseDto> handleValidationException(MethodArgumentNotValidException ex){
		String message = ex.getBindingResult().getFieldError().getDefaultMessage();
		ErrorResponseDto eRes = new ErrorResponseDto();
		eRes.setStatus(HttpStatus.BAD_REQUEST.value());
		eRes.setMessage(message);
		eRes.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(eRes);
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponseDto> handleCustomerNotAvailable(CustomerNotFoundException ex){
		ErrorResponseDto eResponse = new ErrorResponseDto();
		eResponse.setStatus(HttpStatus.NOT_FOUND.value());
		eResponse.setMessage(ex.getMessage());
		eResponse.setTimestamp(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(eResponse);
		
	}
	
}
