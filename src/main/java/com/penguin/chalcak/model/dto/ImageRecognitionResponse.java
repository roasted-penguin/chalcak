package com.penguin.chalcak.model.dto;

import java.util.List;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ImageRecognitionResponse {
    //CLOVA OCR V2
	private String uid;
	private String name;
	private String inferResult;
	private String message;
	private MatchedTemplate matchedTemplate;
	private String title;
	private List<Field> fields;
	private ValidationResult validationResult;
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	public static class MatchedTemplate{
		private int id;
		private String name;
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	public static class Field{
		private String name;
		private String valueType;
		private String inferText;
		private double inferConfidence;
		private Bounding bounding;
	}
	
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	public static class Bounding{
		private double top;
		private double left;
		private double width;
		private double height;
	}
	
    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    @AllArgsConstructor
    @Builder
    public static class ValidationResult {
        private String result;
        private String message;
    }
}
