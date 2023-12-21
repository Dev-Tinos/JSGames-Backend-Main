package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameViewCountUpdateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetAvgStarByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GameGetBean {
    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    @Autowired
    private GameViewCountUpdateSmallBean gameViewCountUpdateSmallBean;

    @Autowired
    private ReviewGetAvgStarByGameIdSmallBean reviewGetAvgStarByGameIdSmallBean;

    @Autowired
    private MapperBean mapperBean;
    public GameGetByGameIdResponseDTO exec(Long gameId) {

        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        gameViewCountUpdateSmallBean.exec(gameDAO);

        //Review 평균 가져오기
        Double starAvg = reviewGetAvgStarByGameIdSmallBean.exec(gameDAO.getGameId());

        GameGetByGameIdResponseDTO responseDTO = mapperBean.to(gameDAO, GameGetByGameIdResponseDTO.class);

        responseDTO.setStar(starAvg);

        return responseDTO;
    }
}
