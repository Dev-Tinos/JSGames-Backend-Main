package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.*;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SetRankByMajor {
    private final RankMajorClearSmallBean rankMajorClearSmallBean;
    private final RankMajorSaveSmallBean rankMajorSaveSmallBean;
    private final RankMajorLastUpdatedSmallBean rankMajorLastUpdatedSmallBean;
    // 매일 오후 11시 55분에 실행
    //게임의 1등 부터 100등까지 가중치를 주어 게임마다 Top100유저들에게 가중치를 부여 하여 연산
    @Scheduled(cron = "0 55 23 * * *")
    public StateResponseDTO exec() {
        // RankTop100DAO를 모두 삭제
        rankMajorClearSmallBean.exec();

        // 모든 Major 순회, 각각의 전공마다 10명씩 저장
        for(Major major : Major.values()) {
            rankMajorSaveSmallBean.exec(major);
        }

        // lastUpdated를 현재 시간으로 설정
        rankMajorLastUpdatedSmallBean.setLastUpdated();

        return new StateResponseDTO(true);
    }
}
