package com.penguin.chalcak.controller;

import com.penguin.chalcak.model.dto.ImageRecognitionInternalRequest;
import com.penguin.chalcak.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<?> convertImageToText(@RequestPart MultipartFile imageFile){
        return ResponseEntity.ok().body(imageService.extractText(imageFile));
    }
}
