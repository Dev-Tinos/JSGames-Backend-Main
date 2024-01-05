package com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3SetSmallBean {

    private final AmazonS3 amazonS3Client;

    @Value("${cloud.aws.s3.bucket}")

    private String bucket;
    public void exec() {
        //S3 초기화
        ListObjectsV2Request req = new ListObjectsV2Request().withBucketName(bucket);
        ListObjectsV2Result result;

        do {
            result = amazonS3Client.listObjectsV2(req);

            for (S3ObjectSummary objectSummary : result.getObjectSummaries()) {
                String key = objectSummary.getKey();
                amazonS3Client.deleteObject(bucket, key);
            }

            // 다음 페이지의 객체들을 가져오기 위한 토큰 설정
            String token = result.getNextContinuationToken();
            req.setContinuationToken(token);
        } while (result.isTruncated());

        //".\\src\\main\\resources\\static\\default_image\\default_user_image.png" 이미지 S3에 업로드
        amazonS3Client.putObject(bucket, "default_user_image.png", new java.io.File(".\\src\\main\\resources\\static\\default_image\\default_user_image.png"));
    }
}
