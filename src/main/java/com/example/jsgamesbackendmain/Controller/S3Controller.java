package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Service.S3Service;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@CrossOrigin("*")
public class S3Controller {
    @Autowired
    private S3Service s3Service;

    @Operation(summary = "사진 업로드")
    @PostMapping("/S3")
    public String uploadImage(@RequestBody MultipartFile file) throws IOException {
        return s3Service.uploadImage(file);
    }

    @Operation(summary = "사진 삭제")
    @DeleteMapping("/S3")
    public String deleteImage(@RequestParam String fileUrl) {
        return s3Service.deleteImage(fileUrl);
    }
}
