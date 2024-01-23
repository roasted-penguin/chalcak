package com.penguin.chalcak.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ApplicationException extends RuntimeException{
	private ApplicationErrorType applicationErrorType;
}
