package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogGetRankSmallBean {
    @Autowired
    private LogRepository logRepository;

    public Long exec(GameDAO gameDAO, LogDAO logDAO) {
        Long rank = 0L;
        switch (gameDAO.getScoreType()) {
            case INFINITE:
                rank = logRepository.getRankInfinite(logDAO.getGameScore(), logDAO.getGameId());
                break;
            case GOAL:
                rank = logRepository.getRankGoal(gameDAO.getTargetScore(), logDAO.getGameScore(), logDAO.getGameId());
                break;
        }

        return rank;
    }
}
