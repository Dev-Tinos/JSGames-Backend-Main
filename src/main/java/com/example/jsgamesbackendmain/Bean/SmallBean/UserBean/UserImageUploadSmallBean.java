package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.PutObjectRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Component
public class UserImageUploadSmallBean {
    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    public String exec(String userEmail, MultipartFile image) throws IOException {
        File fileObj = convertMultiPartFileToFile(image);
        String fileName = userEmail + "_" + image.getOriginalFilename();
        amazonS3Client.putObject(new PutObjectRequest(bucket, fileName, fileObj));
        String fileUrl = amazonS3Client.getUrl(bucket, fileName).toString();
        fileObj.delete();
        return fileUrl;
    }

    private File convertMultiPartFileToFile(MultipartFile file) throws IOException {
        File convertedFile = new File(file.getOriginalFilename());
        try (FileOutputStream fos = new FileOutputStream(convertedFile)) {
            fos.write(file.getBytes());
        }
        return convertedFile;
    }
}
