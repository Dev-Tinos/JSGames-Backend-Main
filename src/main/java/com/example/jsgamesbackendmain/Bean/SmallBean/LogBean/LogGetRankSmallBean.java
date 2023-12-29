package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogGetRankSmallBean {
    private final LogRepository logRepository;

    public Long exec(GameDAO gameDAO, LogDAO logDAO) {
        Long rank = 0L;
        switch (gameDAO.getScoreType()) {
            case INFINITE:
                rank = logRepository.getRankInfinite(logDAO.getGameScore(), logDAO.getGame().getGameId());
                break;
            case GOAL:
                rank = logRepository.getRankGoal(gameDAO.getTargetScore(), logDAO.getGameScore(), logDAO.getGame().getGameId());
                break;
        }

        return rank;
    }
}
