package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByGamIdUserIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByGameIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByUserIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogPostBean;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LogService {

    @Autowired
    private LogGetByGameIdBean logGetByGameIdBean;
    @Autowired
    private LogGetByUserIdBean logGetByUserIdBean;
    @Autowired
    private LogGetByGamIdUserIdBean logGetByGamIdUserIdBean;
    @Autowired
    private LogPostBean logPostBean;

    public LogPostResponseDTO postLog(LogPostRequestDTO logPostRequestDTO) {
        return logPostBean.postLog(logPostRequestDTO);
    }

    public List<LogGetByGameIdResponseDTO> getLogsByGameId(Long gameId, Long page, Long size) {
        List<LogDAO> daoList = logGetByGameIdBean.exec(gameId, page, size);
        return daoList.stream().map(LogGetByGameIdResponseDTO::of).collect(Collectors.toList());
    }

    public List<LogGetByUserIdResponseDTO> getLogsByUserId(Long userId, Long page, Long size) {
        return logGetByUserIdBean.exec(userId, page, size);
    }

    public LogGetByGameIdUserIdResponseDTO getLogByGameIdUserId(Long gameId, Long userId) {
        return logGetByGamIdUserIdBean.exec(gameId, userId);
    }
}
