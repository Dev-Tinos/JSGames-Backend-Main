package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogCatchTopChange {
    private final LogGetByGameSmallBean logGetByGameSmallBean;

    public Boolean exec(Optional<LogDAO> preTopLogOpt, Optional<LogDAO> nextTopLogOpt) {
        //if preTopLog not exist return false
        if (!preTopLogOpt.isPresent())
            return false;


        // get top log
        LogDAO preTopLog = preTopLogOpt.get();
        LogDAO nextTopLog = nextTopLogOpt.get();

        // get log count
        Long logCount = logGetByGameSmallBean.count(preTopLog.getGame());

        // if count <= 100 return false
        if(logCount <= 100)
            return false;

        // if preTopLog != nextTopLog and different user return true
        return !preTopLog.getLogId().equals(nextTopLog.getLogId())
                && !preTopLog.getUser().getUserId().equals(nextTopLog.getUser().getUserId());
    }
}
