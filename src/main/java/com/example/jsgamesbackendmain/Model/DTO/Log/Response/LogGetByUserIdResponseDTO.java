package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LogGetByUserIdResponseDTO {
    private Long logId;
    private Long gameId;
    private Double gameScore;
    private LocalDateTime createdAt;
    private UserLogResponseDTO user;

    public static LogGetByUserIdResponseDTO of(LogDAO log) {
        return LogGetByUserIdResponseDTO.builder()
                .logId(log.getLogId())
                .gameId(log.getGame().getGameId())
                .gameScore(log.getGameScore())
                .createdAt(log.getCreatedAt())
                .user(UserLogResponseDTO.of(log.getUser()))
                .build();
    }
}
