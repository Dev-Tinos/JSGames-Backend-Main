package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserValidationSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogPostBean {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserValidationSmallBean userValidationSmallBean;

    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    public LogPostResponseDTO postLog(LogPostRequestDTO logPostRequestDTO) {
        // game found
        gameGetSmallBean.exec(logPostRequestDTO.getGameId());

        // user found
        userValidationSmallBean.exec(logPostRequestDTO.getUserId());

        LogDAO logDAO = logPostRequestDTO.toDAO();

        return LogPostResponseDTO.of(logRepository.save(logDAO));
    }

}
