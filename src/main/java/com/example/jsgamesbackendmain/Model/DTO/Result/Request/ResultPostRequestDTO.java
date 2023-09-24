package com.example.jsgamesbackendmain.Model.DTO.Result.Request;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultPostRequestDTO {

    private Long userId;
    private Long gameId;
    private Double gameScore;

    public ResultDAO toDAO() {
        ResultDAO resultDAO = new ResultDAO();
        resultDAO.setUserId(this.getUserId());
        resultDAO.setGameId(this.getGameId());
        resultDAO.setGameScore(this.getGameScore());

        return resultDAO;
    }
}
