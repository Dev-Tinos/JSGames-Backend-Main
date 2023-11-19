package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RankTop100ClearSmallBean {
    @Autowired
    private RankRepository rankRepository;

    public void exec() {
        // RankTop100DAO를 모두 삭제
        rankRepository.deleteAll();
    }
}
