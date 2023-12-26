package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogSaveSmallBean {
    private final LogRepository logRepository;

    public LogDAO exec(LogDAO logDAO) {
        return logRepository.save(logDAO);
    }
}
