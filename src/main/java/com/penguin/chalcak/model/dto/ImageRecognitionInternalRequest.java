package com.penguin.chalcak.model.dto;

import org.springframework.web.multipart.MultipartFile;

public record ImageRecognitionInternalRequest(
        MultipartFile image
) {
}
