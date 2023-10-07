package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class GameViewCountUpdateSmallBean {
    @Transactional
    public Long exec(GameDAO gameDAO) {
        gameDAO.setViewCount(gameDAO.getViewCount() + 1);
        return gameDAO.getViewCount();
    }
}
