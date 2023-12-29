package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Repository.RankMajorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RankMajorClearSmallBean {
    private final RankMajorRepository rankRepository;

    public void exec() {
        // RankMajorDAO를 모두 삭제
        rankRepository.deleteAll();
    }
}
