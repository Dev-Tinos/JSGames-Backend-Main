package com.example.jsgamesbackendmain.Bean.RankBean;

import com.example.jsgamesbackendmain.Repository.RankRepository;
import com.example.jsgamesbackendmain.Repository.RankWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankTop100ClearBean {
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private RankWeightRepository rankWeightRepository;

    public void exec() {
        // RankTop100DAO를 모두 삭제
        rankRepository.deleteAll();

        // RankWeightDAO를 모두 삭제
        rankWeightRepository.deleteAll();
    }
}
