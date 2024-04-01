package com.penguin.chalcak.model.dto;

import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class ImageRecognitionInternalResponse {
    private String inferredText;
    private double inferredConfidence;
}
