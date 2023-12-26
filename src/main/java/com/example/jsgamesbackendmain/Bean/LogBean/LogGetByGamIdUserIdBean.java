package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameIdUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetRankSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LogGetByGamIdUserIdBean {
    private final GameGetSmallBean gameGetSmallBean;
    private final LogGetByGameIdUserIdSmallBean logGetByGameIdUserIdSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final LogGetRankSmallBean logGetRankSmallBean;


    public LogGetByGameIdUserIdResponseDTO exec(Long gameId, String userId) {

        // GameId 유효성 검사 및 GameDAO 조회
        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        // UserDAO 조회
        UserDAO userDAO = userGetByIdSmallBean.exec(userId);

        // LogDAO 조회
        LogDAO logDAO = logGetByGameIdUserIdSmallBean.exec(gameDAO, userId);

        // rank 조회
        Long rank = logGetRankSmallBean.exec(gameDAO, logDAO);

        // LogDAO -> LogGetByGameIdUserIdResponseDTO 변환
        // UserDTO, rank 삽입
        return LogGetByGameIdUserIdResponseDTO.of(logDAO, userDAO, rank);
    }
}
