package com.example.jsgamesbackendmain.Bean.ResultBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean.ResultGetByGameIdUserIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByGameIdUserIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultGetByGamIdUserIdBean {
    @Autowired
    private GameGetSmallBean gameGetSmallBean;
    @Autowired
    private ResultGetByGameIdUserIdSmallBean resultGetByGameIdUserIdSmallBean;

    public ResultGetByGameIdUserIdResponseDTO exec(Long gameId, Long userId) {

        // GameId 유효성 검사 및 GameDAO 조회
        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        // ResultDAO 조회
        ResultDAO dao = resultGetByGameIdUserIdSmallBean.exec(gameDAO, userId);

        return ResultGetByGameIdUserIdResponseDTO.of(dao);
    }
}
