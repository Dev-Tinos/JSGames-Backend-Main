package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ImageBean.DeleteImageInS3;
import com.example.jsgamesbackendmain.Bean.ImageBean.UploadImageInS3;
import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final UploadImageInS3 s3UploadImageBean;

    private final DeleteImageInS3 s3DeletImageBean;

    @Transactional
    public S3UrlResponseDTO uploadImage(MultipartFile file) throws IOException {
        return s3UploadImageBean.exec(file);
    }
    @Transactional
    public StateResponseDTO deleteImage(String fileUrl) {
        return s3DeletImageBean.exec(fileUrl);
    }
}
