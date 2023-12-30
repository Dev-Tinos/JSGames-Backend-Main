package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import org.springframework.stereotype.Component;

@Component
public class GameViewCountUpdateSmallBean {
    public Long exec(GameDAO gameDAO) {
        return gameDAO.increaseViewCount();
    }
}
