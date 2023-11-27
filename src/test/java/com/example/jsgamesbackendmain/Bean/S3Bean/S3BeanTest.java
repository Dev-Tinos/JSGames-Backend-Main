package com.example.jsgamesbackendmain.Bean.S3Bean;

import com.amazonaws.services.s3.AmazonS3;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class S3BeanTest {
    @Autowired
    private AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")
    private String bucket;

    @Autowired
    private S3UploadImageBean s3UploadImageBean;
    @Test
    void S3UploadImageBeanTest() throws Exception {
        // given
        // when
        // then
    }
    @Autowired
    private S3DeletImageBean s3DeletImageBean;
    @Test
    void S3DeletImageBeanTest() throws Exception {
        // given
        // when
        // then
    }
}
