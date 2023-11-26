package com.example.jsgamesbackendmain.Bean.S3Bean;

import com.example.jsgamesbackendmain.Bean.SmallBean.S3Bean.S3DeleteSmallBeam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class S3DeletImageBean {
    @Autowired
    private S3DeleteSmallBeam s3DeleteSmallBeam;

    public String exec(String fileUrl) {
        s3DeleteSmallBeam.exec(fileUrl);
        return "Successfully deleted";
    }
}
