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
@AllArgsConstructor
@NoArgsConstructor
public class LogGetByGameIdUserIdResponseDTO {
    private Long logId;
    private Long gameId;
    private Double gameScore;
    private UserLogResponseDTO user;
    private Long ranking;

    public static LogGetByGameIdUserIdResponseDTO of(LogDAO logDAO, UserDAO userDAO, Long ranking) {
        return LogGetByGameIdUserIdResponseDTO.builder()
                .logId(logDAO.getLogId())
                .gameId(logDAO.getGame().getGameId())
                .gameScore(logDAO.getGameScore())
                .user(UserLogResponseDTO.of(userDAO))
                .ranking(ranking)
                .build();
    }
}
