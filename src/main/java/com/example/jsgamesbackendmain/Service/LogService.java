package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByGamIdUserIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByGameIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogGetByUserIdBean;
import com.example.jsgamesbackendmain.Bean.LogBean.LogPostBean;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LogService {

    private final LogGetByGameIdBean logGetByGameIdBean;
    private final LogGetByUserIdBean logGetByUserIdBean;
    private final LogGetByGamIdUserIdBean logGetByGamIdUserIdBean;
    private final LogPostBean logPostBean;

    @Transactional
    public LogPostResponseDTO postLog(LogPostRequestDTO logPostRequestDTO) {
        return logPostBean.exec(logPostRequestDTO);
    }

    @Transactional
    public List<LogGetByGameIdResponseDTO> getLogsByGameId(Long gameId, Integer page, Integer size) {
        return logGetByGameIdBean.exec(gameId, page, size);
    }

    @Transactional
    public List<LogGetByUserIdResponseDTO> getLogsByUserId(String userId, Integer page, Integer size) {
        return logGetByUserIdBean.exec(userId, page, size);
    }

    @Transactional
    public LogGetByGameIdUserIdResponseDTO getLogByGameIdUserId(Long gameId, String userId) {
        return logGetByGamIdUserIdBean.exec(gameId, userId);
    }
}
