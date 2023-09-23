package com.example.jsgamesbackendmain.Model.DTO.Game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameCreateResponseDTO {
    private String status;
    private String message;
    private Long gameId;

    public static GameCreateResponseDTO of(Long gameId, String status, String message) {
        GameCreateResponseDTO response = new GameCreateResponseDTO();
        response.setGameId(gameId);
        response.setStatus(status);
        response.setMessage(message);
        return response;
    }
}