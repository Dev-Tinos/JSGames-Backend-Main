package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.SetEmail;
import com.example.jsgamesbackendmain.Bean.ImageBean.SetImageInS3;
import com.example.jsgamesbackendmain.Bean.RankBean.SetRankByMajor;
import com.example.jsgamesbackendmain.Bean.RankBean.SetRankTop100Users;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final SetEmail emailClearBean;

    private final SetRankTop100Users rankSetTop100UserBean;

    private final SetRankByMajor rankSetMajorBean;

    private final SetImageInS3 s3SetImageBean;

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
