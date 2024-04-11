package com.penguin.chalcak.service;

import com.penguin.chalcak.model.dto.ImageRecognitionInternalRequest;
import com.penguin.chalcak.model.dto.ImageRecognitionInternalResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    ImageRecognitionInternalResponse extractText(MultipartFile imageFile);
}
