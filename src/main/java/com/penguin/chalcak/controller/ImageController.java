package com.penguin.chalcak.controller;

import com.penguin.chalcak.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<?> convertImageToText(@RequestBody MultipartFile image){
        return ResponseEntity.ok().body(imageService.extractText(image));
    }
}
