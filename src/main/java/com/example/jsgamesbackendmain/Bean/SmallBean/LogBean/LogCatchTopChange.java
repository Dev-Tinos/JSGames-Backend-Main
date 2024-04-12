package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Bean.LogBean.GetLogsByGameId;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LogCatchTopChange {
    private final LogGetByGameSmallBean logGetByGameSmallBean;
    private final GetLogsByGameId logGetByGameIdBean;

    public Boolean exec(GameDAO game) {
        // get log count
        Long logCount = logGetByGameSmallBean.count(game);

        // if count <= 100 return false
        if(logCount <= 100)
            return false;

        List<LogGetByGameIdResponseDTO> logList
                = logGetByGameIdBean.exec(game.getGameId(), 0, 2);

        LogGetByGameIdResponseDTO firstLog = logList.get(0);
        UserLogResponseDTO firstLogUser = firstLog.getUser();

        LogGetByGameIdResponseDTO secondLog = logList.get(1);
        UserLogResponseDTO secondLogUser = secondLog.getUser();

        // 100번째 로그의 유저와 101번째 로그의 유저가 다르면 true
        return !firstLogUser.getUserId().equals(secondLogUser.getUserId());
    }
}
