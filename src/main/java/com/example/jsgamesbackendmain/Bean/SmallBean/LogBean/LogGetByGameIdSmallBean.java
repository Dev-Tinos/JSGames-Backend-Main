package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;


import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogGetByGameIdSmallBean {
    @Autowired
    private LogRepository logRepository;


    // INFINITE
    public List<LogDAO> exec(GameDAO gameDAO, Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue());

        Page<LogDAO> order = null;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                order = logRepository.findByGameIdOrderByGameScoreDesc(gameDAO.getGameId(), pageable);
                break;
            case GOAL:
                order = logRepository.findByGameIdOrderByGameScoreWithTargetScore(gameDAO.getGameId(),gameDAO.getTargetScore(), pageable);
                break;
        }

        return order.toList();
    }
}
