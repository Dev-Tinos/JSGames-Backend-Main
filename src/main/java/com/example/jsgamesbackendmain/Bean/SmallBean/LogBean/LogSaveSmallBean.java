package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogSaveSmallBean {
    @Autowired
    private LogRepository logRepository;

    public LogDAO exec(LogDAO logDAO) {
        return logRepository.save(logDAO);
    }
}
