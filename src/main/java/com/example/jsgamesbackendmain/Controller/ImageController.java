package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Service.ImageService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ImageController {
    private final ImageService imageService;

    @Operation(summary = "사진 업로드")
    @PostMapping(value = "/Image",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public S3UrlResponseDTO uploadImage(@RequestBody MultipartFile file) throws IOException {
        return imageService.uploadImage(file);
    }

    @Operation(summary = "사진 삭제")
    @DeleteMapping("/Image")
    public StateResponseDTO deleteImage(@RequestParam String fileUrl) {
        return imageService.deleteImage(fileUrl);
    }
}
