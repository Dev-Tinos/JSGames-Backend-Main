package com.example.jsgamesbackendmain.Bean.ImageBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3SetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class S3SetImageBean {
    private final S3SetSmallBean s3SetSmallBean;

    public StateResponseDTO exec() {
        s3SetSmallBean.exec();
        return new StateResponseDTO(true);
    }
}
