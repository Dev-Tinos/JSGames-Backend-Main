package com.example.jsgamesbackendmain.Model.DTO.Log.Request;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogPostRequestDTO {

    private String userId;
    private Long gameId;
    private Double gameScore;

    public LogDAO toDAO() {
        LogDAO logDAO = new LogDAO();
        logDAO.setUserId(this.getUserId());
        logDAO.setGameId(this.getGameId());
        logDAO.setGameScore(this.getGameScore());

        return logDAO;
    }

    public static LogPostRequestDTO of(LogDAO logDAO) {
        return LogPostRequestDTO.builder()
                .userId(logDAO.getUserId())
                .gameId(logDAO.getGameId())
                .gameScore(logDAO.getGameScore())
                .build();
    }
}
