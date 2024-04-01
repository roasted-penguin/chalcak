package com.penguin.chalcak.service;

import com.penguin.chalcak.model.dto.ImageRecognitionInternalResponse;
import org.springframework.stereotype.Service;

@Service
public interface ImageService {
    ImageRecognitionInternalResponse extractText(String imageUrl);
}
