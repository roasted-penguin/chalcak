package com.penguin.chalcak.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationErrorType {
	
	APPLICATION_DEFAULT_ERROR(HttpStatus.BAD_REQUEST,-100,"디폴트 에러");
	
	
	private HttpStatus httpStatus;
	private int errorCode;
	private String message;
}
