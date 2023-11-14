package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
public class LogGetResponse {
    private Long logId;
    private Long gameId;
    private Double gameScore;

    public static void mapFromDAO(LogGetResponse logGetResponse, LogDAO logDAO) {
        logGetResponse.setLogId(logDAO.getLogId());
        logGetResponse.setGameId(logDAO.getGameId());
        logGetResponse.setGameScore(logDAO.getGameScore());
    }
}
