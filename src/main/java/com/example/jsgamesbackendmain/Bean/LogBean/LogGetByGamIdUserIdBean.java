package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameIdUserIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetRankSmallBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserGetBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogGetByGamIdUserIdBean {
    @Autowired
    private GameGetSmallBean gameGetSmallBean;
    @Autowired
    private LogGetByGameIdUserIdSmallBean logGetByGameIdUserIdSmallBean;
    @Autowired
    private UserGetBean userGetBean;
    @Autowired
    private LogGetRankSmallBean logGetRankSmallBean;

    @Autowired
    private MapperBean mapperBean;


    public LogGetByGameIdUserIdResponseDTO exec(Long gameId, Long userId) {

        // GameId 유효성 검사 및 GameDAO 조회
        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        // UserDAO 조회
        UserLogResponseDTO userDTO = mapperBean.to(userGetBean.getUser(userId), UserLogResponseDTO.class);

        // LogDAO 조회
        LogDAO logDAO = logGetByGameIdUserIdSmallBean.exec(gameDAO, userId);

        // rank 조회
        Long rank = logGetRankSmallBean.exec(gameDAO, logDAO);

        // LogDAO -> LogGetByGameIdUserIdResponseDTO 변환
        LogGetByGameIdUserIdResponseDTO dto = mapperBean.to(logDAO, LogGetByGameIdUserIdResponseDTO.class);

        // UserDTO, rank 삽입
        dto.setUser(userDTO);
        dto.setRanking(rank);

        return dto;
    }
}
