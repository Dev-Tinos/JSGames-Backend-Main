package com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.example.jsgamesbackendmain.Model.DTO.S3.S3UrlResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class S3UploadSmallBean {

    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    
    public S3UrlResponseDTO exec(MultipartFile file) throws IOException {
        File fileObj = convertMultiPartFileToFile(file);
        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, fileObj));
        String fileUrl = amazonS3Client.getUrl(bucket, fileName).toString();
        fileObj.delete();
        return new S3UrlResponseDTO(fileUrl);
    }
    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
}