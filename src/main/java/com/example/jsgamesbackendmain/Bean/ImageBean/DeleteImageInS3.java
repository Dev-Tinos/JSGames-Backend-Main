package com.example.jsgamesbackendmain.Bean.ImageBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteImageInS3 {
    private final S3DeleteSmallBeam s3DeleteSmallBeam;

    public StateResponseDTO exec(String fileUrl) {
        s3DeleteSmallBeam.exec(fileUrl);
        return new StateResponseDTO(true);
    }
}
