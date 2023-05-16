package com.example.stationery.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@CrossOrigin("http://127.0.0.1:5500")
@RestController
@RequestMapping("image")
public class ImageController {

    @Value("${upload.directory}")
    private String uploadDirectory;

    @PostMapping("/upload")
    public ResponseEntity<String> handleFileUpload(@RequestParam("imageFile") MultipartFile file) {
        if (!file.isEmpty()) {
            try {
                String fileName = file.getOriginalFilename();
                String filePath = uploadDirectory + File.separator + fileName;
                file.transferTo(new File(filePath));
                // Process the uploaded file as needed
                return ResponseEntity.status(HttpStatus.OK).body(filePath);
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error uploading image");
            }
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No image file provided");
        }
    }
}
