package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LogGetOrderInfiniteScoreSmallBean {

    @Autowired
    private LogRepository logRepository;

    public Optional<LogDAO> exec(Long gameId, String userId) {
        return logRepository.findFirstByGameIdAndUserIdOrderByGameScoreDesc(gameId, userId);
    }
}
