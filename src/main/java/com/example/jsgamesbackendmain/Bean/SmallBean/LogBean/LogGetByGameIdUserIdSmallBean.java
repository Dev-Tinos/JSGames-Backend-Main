package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LogGetByGameIdUserIdSmallBean {
    @Autowired
    private LogValidationSmallBean logValidationSmallBean;
    @Autowired
    private LogGetOrderInfiniteScoreSmallBean logGetOrderInfiniteScoreSmallBean;
    @Autowired
    private LogGetOrderTargetSmallBean logGetOrderTargetSmallBean;

    public LogDAO exec(GameDAO gameDAO, String userId) {

        Optional<LogDAO> optional = logValidationSmallBean.exec(gameDAO, userId);;

        switch (gameDAO.getScoreType()) {
            case INFINITE:
                optional = logGetOrderInfiniteScoreSmallBean.exec(gameDAO.getGameId(), userId);
                break;
            case GOAL:
                optional = logGetOrderTargetSmallBean.exec(gameDAO.getGameId(), userId, gameDAO.getTargetScore());
                break;
        }

        return optional.get();
    }
}
