package com.penguin.chalcak.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@ToString
public class ImageRecognitionExternalRequest {
    private String version;
    private String requestId;
    private long timestamp;
    private String lang;
    //list 형식이지만 현재는 한개만 허용 20240123
    private List<Image> images;
    private boolean enableTableDetection;

    @Getter
    @Setter
    @Builder
    @ToString
    public static class Image {
        private String format;
        private String url;
        private String data;
        private String name;
        //텍스트 OCR API에서는 사용되지 않음
        //private JSONArray templateIds;
    }
}
