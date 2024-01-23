package com.penguin.chalcak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.penguin.chalcak.exception.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler({ApplicationException.class})
	public ResponseEntity<?> handle(ApplicationException ex){
		ApplicationErrorType applicationErrorType = ex.getApplicationErrorType();
		HttpStatus httpStatus = applicationErrorType.getHttpStatus();
		ErrorResponse errorResponse = ErrorResponse.builder()
				.errorCode(applicationErrorType.getErrorCode())
				.message(applicationErrorType.getMessage())
				.build();
		
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
	
	@ExceptionHandler({Exception.class})
	public ResponseEntity<?> handle(Exception exception){
		return ResponseEntity.internalServerError().body(new ErrorResponse());
	}
}
