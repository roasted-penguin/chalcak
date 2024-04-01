package com.penguin.chalcak.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.penguin.chalcak.exception.dto.ErrorResponse;

import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ApplicationException.class)
	public ResponseEntity<?> handle(ApplicationException ex){
		return responseEntityOf(ex.getApplicationErrorType());
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handle(ConstraintViolationException ex){
		return responseEntityOf(ApplicationErrorType.CONSTRAINT_VIOLATION_EXCEPTION);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handle(MethodArgumentNotValidException ex){
		return responseEntityOf(ApplicationErrorType.METHOD_ARGUMENT_NOT_VALID_EXCEPTION);
	}

	@ExceptionHandler(NoResourceFoundException.class)
	public ResponseEntity<?> handle(NoResourceFoundException ex){
		return responseEntityOf(ApplicationErrorType.NO_RESOURCE_EXCEPTION);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> handle(Exception ex){
		ex.printStackTrace();
		return responseEntityOf(ApplicationErrorType.UNHANDLED_EXCEPTION);
	}
	
	
	
	private static String loggerMessageBuilder(ApplicationErrorType applicationErrorType) {
		return applicationErrorType.getErrorCode() + " : " + applicationErrorType.getMessage();
	}
	
	private static ResponseEntity<?> responseEntityOf(ApplicationErrorType applicationErrorType){
		log.info(loggerMessageBuilder(applicationErrorType));
		
		HttpStatus httpStatus = applicationErrorType.getHttpStatus();
		ErrorResponse errorResponse = ErrorResponse.builder()
				.errorCode(applicationErrorType.getErrorCode())
				.message(applicationErrorType.getMessage())
				.build();
		return ResponseEntity.status(httpStatus).body(errorResponse);
	}
}
