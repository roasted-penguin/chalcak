package com.penguin.chalcak.model.dto;

import java.util.List;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class ImageRecognitionExternalResponse {
	//CLOVA OCR V2
	private String version;
	private String requestId;
	private String timestamp;
	private List<Image> images;
	@Getter
	@NoArgsConstructor(access = AccessLevel.PROTECTED)
	@AllArgsConstructor
	@Builder
	@ToString
	public static class Image{
		private String uid;
		private String name;
		private String inferResult;
		private String message;
		private ValidationResult validationResult;
		private ConvertedImageInfo convertedImageInfo;
		private MatchedTemplate matchedTemplate;
		private CombineResult combineResult;
		private List<Table> tables;
		private List<Field> fields;

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class MatchedTemplate{
			private int id;
			private String name;
		}

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class ValidationResult{
			private String result;
			private String message;
		}

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class ConvertedImageInfo{
			private int width;
			private int height;
			private int pageIndex;
			private boolean longImage;
		}

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class CombineResult{
			private String name;
			private String text;
		}

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class Table{
			private String msg;
		}

		@Getter
		@NoArgsConstructor(access = AccessLevel.PROTECTED)
		@AllArgsConstructor
		@Builder
		@ToString
		public static class Field{
			private String name;
			private String valueType;
			private String inferText;
			private double inferConfidence;
			private BoundingPoly boundingPoly;
			private String type;
			private boolean checked;
			private boolean lineBreak;
			private List<SubField> subFields;
			@Getter
			@NoArgsConstructor(access = AccessLevel.PROTECTED)
			@AllArgsConstructor
			@Builder
			@ToString
			public static class BoundingPoly{
				private List<Verticle> verticles;

				@Getter
				@NoArgsConstructor(access = AccessLevel.PROTECTED)
				@AllArgsConstructor
				@Builder
				@ToString
				public static class Verticle{
					private double x;
					private double y;
				}
			}
			@Getter
			@NoArgsConstructor(access = AccessLevel.PROTECTED)
			@AllArgsConstructor
			@Builder
			@ToString
			public static class SubField{
				private BoundingPoly boundingPoly;
				private String inferText;
				private double inferConfidence;
				private boolean lineBreak;
			}
		}
	}

}


/**

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
    public static class ValidationResult{
        private String result;
        private String message;
    }
}
**/