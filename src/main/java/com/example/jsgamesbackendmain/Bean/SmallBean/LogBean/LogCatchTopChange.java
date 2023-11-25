package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class LogCatchTopChange {
    @Autowired
    private LogGetByGameSmallBean logGetByGameSmallBean;

    public Boolean exec(Optional<LogGetByGameIdResponseDTO> preTopLogOpt, Optional<LogGetByGameIdResponseDTO> nextTopLogOpt) {
        //if preTopLog not exist return false
        if (!preTopLogOpt.isPresent())
            return false;


        // get top log
        LogGetByGameIdResponseDTO preTopLog = preTopLogOpt.get();
        LogGetByGameIdResponseDTO nextTopLog = nextTopLogOpt.get();

        System.out.println("preTopLog = " + preTopLog);

        // get log count
        Long logCount = logGetByGameSmallBean.count(preTopLog.getGameId());

        // if count <= 100 return false
        if(logCount <= 100)
            return false;

        // if preTopLog != nextTopLog and different user return true
        if (!preTopLog.getLogId().equals(nextTopLog.getLogId())
                && !preTopLog.getUser().getUserId().equals(nextTopLog.getUser().getUserId()))
            return true;

        return false;
    }
}
