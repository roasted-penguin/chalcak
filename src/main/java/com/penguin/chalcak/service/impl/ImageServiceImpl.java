package com.penguin.chalcak.service.impl;

import com.penguin.chalcak.model.dto.ImageRecognitionRequest;
import com.penguin.chalcak.model.dto.ImageRecognitionResponse;
import com.penguin.chalcak.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageServiceImpl implements ImageService {
    public ImageRecognitionResponse extractText(MultipartFile image){
        return null;
    }
}
