package com.penguin.chalcak.model.dto;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ImageRecognitionRequest {
    private String version;
    private String requestId;
    private long timestamp;
    private String lang;
    private List<Image> images;
    private boolean enableTableDetection;

    @Getter
    @Setter
    @Builder
    public static class Image {
        private String format;
        private String url;
        private String data;
        private String name;
        //private JSONArray templateIds;
    }
}
