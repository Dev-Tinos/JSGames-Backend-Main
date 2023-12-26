package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogGetByGameIdResponseDTO {
    private Long logId;
    private Long gameId;
    private Double gameScore;
    private UserLogResponseDTO user;

    public static LogGetByGameIdResponseDTO of(LogDAO logDAO, UserDAO userDAO) {
        return LogGetByGameIdResponseDTO.builder()
                .logId(logDAO.getLogId())
                .gameId(logDAO.getGameId())
                .gameScore(logDAO.getGameScore())
                .user(UserLogResponseDTO.of(userDAO))
                .build();
    }
}
