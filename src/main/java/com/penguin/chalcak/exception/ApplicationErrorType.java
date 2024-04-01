package com.penguin.chalcak.exception;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ApplicationErrorType {	
	APPLICATION_DEFAULT_ERROR(HttpStatus.BAD_REQUEST,-100,"디폴트 에러"),
	UNHANDLED_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-1000,"Unhandled Exception"),
	CONSTRAINT_VIOLATION_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-1001,"Constraint Violation Exception"),
	METHOD_ARGUMENT_NOT_VALID_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-1002,"Method Argument Not Valid Exception"),
	JSON_MAPPING_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-1003,"Json Mapping Exception"),
	JSON_PROCESSING_EXCEPTION(HttpStatus.INTERNAL_SERVER_ERROR,-1004,"Json Processing Exception"),
	NO_RESOURCE_EXCEPTION(HttpStatus.BAD_REQUEST,-1005,"해당 URL이 존재하지 않습니다."),

	NAVER_EXTERNAL_API_EXCEPTION(HttpStatus.BAD_REQUEST,-10000,"네이버 CLOVA OCR API 호출 과정에서 오류 발생");
	
	private HttpStatus httpStatus;
	private int errorCode;
	private String message;
}
