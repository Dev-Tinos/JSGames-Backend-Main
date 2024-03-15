package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogGetByIdSmallBean {
    private final LogRepository logRepository;

    public LogDAO exec(Long logId) {
        Optional<LogDAO> logOpt = logRepository.findById(logId);
        if (!logOpt.isPresent()) {
            throw new RuntimeException("Log not found for this LogId :: " + logId);
        } else {
            return logOpt.get();
        }
    }
}
