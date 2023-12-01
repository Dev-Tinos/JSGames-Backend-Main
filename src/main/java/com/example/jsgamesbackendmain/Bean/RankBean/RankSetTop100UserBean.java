package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankLastUpdatedSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.RankBean.RankTop100ClearSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class RankSetTop100UserBean {
    @Autowired
    private RankTop100ClearSmallBean rankTop100ClearSmallBean;
    @Autowired
    private RankLastUpdatedSmallBean rankLastUpdatedSmallBean;
    @Autowired
    private RankSaveSmallBean rankSaveSmallBean;
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private MapperBean mapperBean;


    // 매일 오후 11시 40분에 실행
    //게임의 1등 부터 100등까지 가중치를 주어 게임마다 Top100유저들에게 가중치를 부여 하여 연산
    @Scheduled(cron = "0 50 23 * * *")
    public void exec() {
        // RankTop100DAO를 모두 삭제
        rankTop100ClearSmallBean.exec();

        // 각 게임의 1등부터 100등까지의 가중치를 더한 것을 저장
        rankSaveSmallBean.exec();

        // lastUpdated를 현재 시간으로 설정
        rankLastUpdatedSmallBean.setLastUpdated();
    }
}
