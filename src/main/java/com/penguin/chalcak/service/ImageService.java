package com.penguin.chalcak.service;

import com.penguin.chalcak.model.dto.ImageRecognitionRequest;
import com.penguin.chalcak.model.dto.ImageRecognitionResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
    ImageRecognitionResponse extractText(MultipartFile image);
}
