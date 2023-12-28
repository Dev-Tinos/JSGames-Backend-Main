package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Repository.RankTop100Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankTop100ClearSmallBean {
    private final RankTop100Repository rankRepository;

    public void exec() {
        // RankTop100DAO를 모두 삭제
        rankRepository.deleteAll();
    }
}
