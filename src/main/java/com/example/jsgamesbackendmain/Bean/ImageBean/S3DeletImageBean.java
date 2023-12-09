package com.example.jsgamesbackendmain.Bean.ImageBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class S3DeletImageBean {
    @Autowired
    private S3DeleteSmallBeam s3DeleteSmallBeam;

    public StateResponseDTO exec(String fileUrl) {
        s3DeleteSmallBeam.exec(fileUrl);
        return new StateResponseDTO(true);
    }
}
