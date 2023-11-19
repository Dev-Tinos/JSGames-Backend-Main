package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LogGetByGameIdBean {
    @Autowired
    private LogGetByGameIdSmallBean logGetByGameIdSmallBean;

    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public List<LogDAO> exec(Long gameId, Long page, Long size) {

        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        return logGetByGameIdSmallBean.exec(gameDAO, page, size);
    }

}
