package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogGetByGameIdResponseDTO {
    private Long logId;
    private Long gameId;
    private Double gameScore;
    private LocalDateTime createdAt;
    private UserLogResponseDTO user;

    public static LogGetByGameIdResponseDTO of(LogDAO logDAO) {
        return LogGetByGameIdResponseDTO.builder()
                .logId(logDAO.getLogId())
                .gameId(logDAO.getGame().getGameId())
                .gameScore(logDAO.getGameScore())
                .createdAt(logDAO.getCreatedAt())
                .user(UserLogResponseDTO.of(logDAO.getUser()))
                .build();
    }
}
