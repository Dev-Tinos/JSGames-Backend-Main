package com.example.jsgamesbackendmain.Model.DTO.Result;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultDTO {

    private Long resultId;
    private Long userId;
    private Long gameId;
    private Double gameScore;

    public static ResultDTO of(ResultDAO resultDAO) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setResultId(resultDAO.getResultId());
        resultDTO.setUserId(resultDAO.getUserId());
        resultDTO.setGameId(resultDAO.getGameId());
        resultDTO.setGameScore(resultDAO.getGameScore());

        return resultDTO;
    }
}
