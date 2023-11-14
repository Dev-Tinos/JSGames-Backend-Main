package com.example.jsgamesbackendmain.Model.DTO.Log.Request;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogPostRequestDTO {

    private Long userId;
    private Long gameId;
    private Double gameScore;

    public LogDAO toDAO() {
        LogDAO logDAO = new LogDAO();
        logDAO.setUserId(this.getUserId());
        logDAO.setGameId(this.getGameId());
        logDAO.setGameScore(this.getGameScore());

        return logDAO;
    }
}