package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.DeleteObjectRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UserImageDeleteSmallBean {
    @Autowired
    private AmazonS3 amazonS3Client;
    @Value("${cloud.aws.s3.bucket}")
    private String bucket;
    @Autowired
    private UserGetSmallBean userGetSmallBean;
    public void exec(String userId) {
        UserDAO user = userGetSmallBean.getUser(userId);
        String userEmailPrefix = user.getEmail() + "_";

        // S3 버킷에서 userEmailPrefix로 시작하는 첫 번째 파일 삭제
        ListObjectsV2Request listObjectsV2Request = new ListObjectsV2Request()
                .withBucketName(bucket)
                .withPrefix(userEmailPrefix)
                .withMaxKeys(1);
        ListObjectsV2Result result = amazonS3Client.listObjectsV2(listObjectsV2Request);

        if (!result.getObjectSummaries().isEmpty()) {
            S3ObjectSummary objectSummary = result.getObjectSummaries().get(0);
            amazonS3Client.deleteObject(new DeleteObjectRequest(bucket, objectSummary.getKey()));
        }
    }

}
