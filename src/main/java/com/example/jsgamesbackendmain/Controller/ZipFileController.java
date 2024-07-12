package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import com.example.jsgamesbackendmain.Service.ZipFileService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ZipFileController {

    private final ZipFileService zipFileService;

    @Operation(summary = "zip 업로드")
    @PostMapping(value = "/zip",
            consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<S3UrlResponseDTO> uploadZipFile(@RequestParam("file") MultipartFile file) throws IOException {
        return zipFileService.uploadZipFile(file);
    }
}
