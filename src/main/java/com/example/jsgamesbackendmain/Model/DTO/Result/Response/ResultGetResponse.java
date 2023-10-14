package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class ResultGetResponse {
    private Long resultId;
    private Long gameId;
    private Double gameScore;

    public static void mapFromDAO(ResultGetResponse resultGetResponse, ResultDAO resultDAO) {
        resultGetResponse.setResultId(resultDAO.getResultId());
        resultGetResponse.setGameId(resultDAO.getGameId());
        resultGetResponse.setGameScore(resultDAO.getGameScore());
    }
}
