package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LogPostResponseDTO {
    private Long logId;
    private Long gameId;
    private Double gameScore;
    private LocalDateTime createdAt;
    private UserLogResponseDTO user;

    public static LogPostResponseDTO of(LogDAO logDAO) {
        return LogPostResponseDTO.builder()
                .logId(logDAO.getLogId())
                .gameId(logDAO.getGame().getGameId())
                .gameScore(logDAO.getGameScore())
                .createdAt(logDAO.getCreatedAt())
                .user(UserLogResponseDTO.of(logDAO.getUser()))
                .build();
    }
}
