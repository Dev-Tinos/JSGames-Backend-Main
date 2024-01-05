package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameViewCountUpdateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetAvgStarByGameIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameGetBean {
    private final GameGetSmallBean gameGetSmallBean;

    private final GameViewCountUpdateSmallBean gameViewCountUpdateSmallBean;

    private final ReviewGetAvgStarByGameIdSmallBean reviewGetAvgStarByGameIdSmallBean;

    public GameGetByGameIdResponseDTO exec(Long gameId) {

        GameDAO findGame = gameGetSmallBean.exec(gameId);

        gameViewCountUpdateSmallBean.exec(findGame);

        //Review 평균 가져오기
        Double starAvg = reviewGetAvgStarByGameIdSmallBean.exec(findGame);

        return GameGetByGameIdResponseDTO.of(findGame, starAvg);
    }
}
