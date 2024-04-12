package com.example.jsgamesbackendmain.Bean.ImageBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3UploadSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class S3UploadImageBean {
    private final S3UploadSmallBean s3UploadSmallBean;

    public S3UrlResponseDTO exec(MultipartFile file) throws IOException {
        return s3UploadSmallBean.exec(file);
    }
}
