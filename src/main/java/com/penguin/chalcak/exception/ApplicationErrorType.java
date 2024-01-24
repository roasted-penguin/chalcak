package com.penguin.chalcak.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationErrorType {	
	APPLICATION_DEFAULT_ERROR(HttpStatus.BAD_REQUEST,-100,"디폴트 에러"),
	UNHANDLED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-10000,"Unhandled Exception"),
	CONSTRAINT_VIOLATION_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-10001,"Constraint Violation Exception"),
	METHOD_ARGUMENT_NOT_VALID_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-10002,"Method Argument Not Valid Exception"),;
	
	
	private HttpStatus httpStatus;
	private int errorCode;
	private String message;
}
