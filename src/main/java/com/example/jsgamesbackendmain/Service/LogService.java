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
import com.fasterxml.jackson.databind.ObjectMapper;
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

    ObjectMapper objectMapper = new ObjectMapper();

    public LogPostResponseDTO postLog(LogPostRequestDTO logPostRequestDTO) {
        return logPostBean.exec(logPostRequestDTO);
    }

    public List<LogGetByGameIdResponseDTO> getLogsByGameId(Long gameId, Integer page, Integer size) {
        return logGetByGameIdBean.exec(gameId, page, size);
    }

    public List<LogGetByUserIdResponseDTO> getLogsByUserId(String userId, Long page, Long size) {
        return logGetByUserIdBean.exec(userId, page, size);
    }

    public LogGetByGameIdUserIdResponseDTO getLogByGameIdUserId(Long gameId, String userId) {
        return logGetByGamIdUserIdBean.exec(gameId, userId);
    }
}
