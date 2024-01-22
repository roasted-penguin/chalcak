package com.penguin.chalcak.controller;

import com.penguin.chalcak.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {
    private final ImageService imageService;

    @PostMapping
    public ResponseEntity<?> convertImageToText(){
        return ResponseEntity.ok().body(imageService.extractText());
    }
}
