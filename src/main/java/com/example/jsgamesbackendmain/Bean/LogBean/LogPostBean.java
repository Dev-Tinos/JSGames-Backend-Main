package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogCatchTopChange;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LogPostBean {
    private final LogSaveSmallBean logSaveSmallBean;

    private final LogCatchTopChange logCatchTopChange;

    private final LogGetByGameSmallBean logGetByGameSmallBean;

    private final UserGetByIdSmallBean userValidationSmallBean;

    private final GameGetSmallBean gameGetSmallBean;


    public LogPostResponseDTO exec(LogPostRequestDTO logPostRequestDTO) {
        // game found
        GameDAO game = gameGetSmallBean.exec(logPostRequestDTO.getGameId());

        // user found
        UserDAO user = userValidationSmallBean.exec(logPostRequestDTO.getUserId());

        // get top log
        Optional<LogGetByGameIdResponseDTO> preTopLog = logGetByGameSmallBean.exec(game, 0, 1).stream().findAny();

        // log save
        LogDAO savedLogDAO = logSaveSmallBean.exec(logPostRequestDTO.toDAO());

        // get top log
        Optional<LogGetByGameIdResponseDTO> nextTopLog = logGetByGameSmallBean.exec(game, 0, 1).stream().findAny();

        // log catch top change
        Boolean isChange = logCatchTopChange.exec(preTopLog, nextTopLog);
        // 여기서 이벤트 처리하면 됨!!!!!

        return LogPostResponseDTO.of(savedLogDAO, user);
    }

}
