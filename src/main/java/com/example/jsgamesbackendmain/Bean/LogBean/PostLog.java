package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogCatchTopChange;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostLog {
    private final LogSaveSmallBean logSaveSmallBean;

    private final LogCatchTopChange logCatchTopChange;

    private final UserGetByIdSmallBean userValidationSmallBean;

    private final GameGetSmallBean gameGetSmallBean;


    public LogPostResponseDTO exec(LogPostRequestDTO logPostRequestDTO) {
        // game found
        GameDAO findGame = gameGetSmallBean.exec(logPostRequestDTO.getGameId());

        // user found
        UserDAO findUser = userValidationSmallBean.exec(logPostRequestDTO.getUserId());

        // log save
        LogDAO newLog = logPostRequestDTO.toDAO();
        newLog.setGame(findGame);
        newLog.setUser(findUser);
        LogDAO savedLog = logSaveSmallBean.exec(newLog);

        // Update User last play time
        findUser.updateLastPlayTime(savedLog.getCreatedAt());

        // log catch top change
        Boolean isChange = logCatchTopChange.exec(findGame);
        // 여기서 이벤트 처리하면 됨!!!!!

        return LogPostResponseDTO.of(savedLog);
    }

}
