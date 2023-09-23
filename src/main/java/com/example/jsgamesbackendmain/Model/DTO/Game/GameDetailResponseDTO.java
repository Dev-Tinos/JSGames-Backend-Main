package com.example.jsgamesbackendmain.Model.DTO.Game;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameDetailResponseDTO {
    private String status;
    private GameDTO data;

    public static GameDetailResponseDTO of(GameDTO gameDetail, String status) {
        GameDetailResponseDTO response = new GameDetailResponseDTO();
        response.setData(gameDetail);
        response.setStatus(status);
        return response;
    }
}
