package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.SetEmail;
import com.example.jsgamesbackendmain.Bean.ImageBean.SetImageInS3;
import com.example.jsgamesbackendmain.Bean.RankBean.SetRankByMajor;
import com.example.jsgamesbackendmain.Bean.RankBean.SetRankTop100Users;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TestService {
    private final SetEmail emailClearBean;

    private final SetRankTop100Users rankSetTop100UserBean;

    private final SetRankByMajor rankSetMajorBean;

    private final SetImageInS3 s3SetImageBean;

    @Scheduled(cron = "0 55 23 * * *")
    @Transactional
    public String emailClear() {
        emailClearBean.exec();
        return "success";
    }

    @Scheduled(cron = "0 55 23 * * *")
    @Transactional
    public StateResponseDTO setRank() {
        rankSetTop100UserBean.exec();
        return StateResponseDTO.builder().state(true).build();
    }

    @Scheduled(cron = "0 55 23 * * *")
    @Transactional
    public StateResponseDTO setMajor() {
        return rankSetMajorBean.exec();
    }

    @Transactional
    public StateResponseDTO setImage() {
        return s3SetImageBean.exec();
    }
}
