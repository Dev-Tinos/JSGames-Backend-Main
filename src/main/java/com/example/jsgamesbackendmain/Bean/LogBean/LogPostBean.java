package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogPostBean {
    @Autowired
    private LogSaveSmallBean logSaveSmallBean;
    @Autowired
    private UserGetByIdSmallBean userValidationSmallBean;
    @Autowired
    private GameGetSmallBean gameGetSmallBean;
    @Autowired
    private MapperBean mapperBean;



    public LogPostResponseDTO exec(LogPostRequestDTO logPostRequestDTO) {
        // game found
        gameGetSmallBean.exec(logPostRequestDTO.getGameId());

        // user found
        userValidationSmallBean.exec(logPostRequestDTO.getUserId());

        LogDAO savedLogDAO = logSaveSmallBean.exec(logPostRequestDTO.toDAO());

        return mapperBean.to(savedLogDAO, LogPostResponseDTO.class);
    }

}
