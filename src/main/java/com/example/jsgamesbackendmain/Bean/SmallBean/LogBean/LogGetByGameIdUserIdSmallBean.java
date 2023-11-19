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

    public LogDAO exec(GameDAO gameDAO, Long userId) {

        Optional<LogDAO> optional = logValidationSmallBean.exec(gameDAO, userId);
        return optional.get();
    }
}
