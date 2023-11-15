package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LogGetOrderTargetSmallBean {
    @Autowired
    private LogRepository logRepository;
    public Optional<LogDAO> exec(Long gameId, Long userId, Double targetScore) {
        return logRepository.findFirstByGameIdAndUserIdOrderByGameScoreWithTargetScore(
                gameId, userId, targetScore, PageRequest.of(0, 1)
        ).stream().findAny();
    }
}
