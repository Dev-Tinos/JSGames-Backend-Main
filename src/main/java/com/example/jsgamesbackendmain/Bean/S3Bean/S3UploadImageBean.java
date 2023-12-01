package com.example.jsgamesbackendmain.Bean.S3Bean;

import com.example.jsgamesbackendmain.Bean.SmallBean.S3Bean.S3UploadSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class S3UploadImageBean {
    @Autowired
    private S3UploadSmallBean s3UploadSmallBean;

    public S3UrlResponseDTO exec(MultipartFile file) throws IOException {
        return s3UploadSmallBean.exec(file);
    }
}
