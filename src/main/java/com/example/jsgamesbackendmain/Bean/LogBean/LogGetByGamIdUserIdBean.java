package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameIdUserIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogGetByGamIdUserIdBean {
    @Autowired
    private GameGetSmallBean gameGetSmallBean;
    @Autowired
    private LogGetByGameIdUserIdSmallBean logGetByGameIdUserIdSmallBean;

    public LogGetByGameIdUserIdResponseDTO exec(Long gameId, Long userId) {

        // GameId 유효성 검사 및 GameDAO 조회
        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        // LogDAO 조회
        LogDAO dao = logGetByGameIdUserIdSmallBean.exec(gameDAO, userId);

        return LogGetByGameIdUserIdResponseDTO.of(dao);
    }
}
