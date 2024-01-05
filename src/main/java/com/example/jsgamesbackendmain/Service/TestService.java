package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailSetBean;
import com.example.jsgamesbackendmain.Bean.ImageBean.S3SetImageBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetMajorBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetTop100UserBean;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final EmailSetBean emailClearBean;

    private final RankSetTop100UserBean rankSetTop100UserBean;

    private final RankSetMajorBean rankSetMajorBean;

    private final S3SetImageBean s3SetImageBean;

    @Transactional
    public String emailClear() {
        emailClearBean.exec();
        return "success";
    }

    @Transactional
    public StateResponseDTO setRank() {
        rankSetTop100UserBean.exec();
        return StateResponseDTO.builder().state(true).build();
    }

    @Transactional
    public StateResponseDTO setMajor() {
        return rankSetMajorBean.exec();
    }

    @Transactional
    public StateResponseDTO setImage() {
        return s3SetImageBean.exec();
    }
}
