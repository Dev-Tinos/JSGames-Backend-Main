package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogGetOrderInfiniteScoreSmallBean {

    private final LogRepository logRepository;

    public Optional<LogDAO> exec(Long gameId, String userId) {
        return logRepository.findFirstByGameIdAndUserIdOrderByGameScoreDesc(gameId, userId);
    }
}
