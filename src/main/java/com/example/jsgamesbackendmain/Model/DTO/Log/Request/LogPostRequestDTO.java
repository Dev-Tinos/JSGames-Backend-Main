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
        return LogDAO.builder()
                .userId(this.getUserId())
                .gameId(this.getGameId())
                .gameScore(this.getGameScore())
                .build();
    }

    public static LogPostRequestDTO of(LogDAO logDAO) {
        return LogPostRequestDTO.builder()
                .userId(logDAO.getUserId())
                .gameId(logDAO.getGameId())
                .gameScore(logDAO.getGameScore())
                .build();
    }
}
