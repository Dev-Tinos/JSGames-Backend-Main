package com.example.jsgamesbackendmain.Model.DTO.Game;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameListResponseDTO {
    private String status;
    private List<GameDTO> data;

    public static GameListResponseDTO of(List<GameDTO> gameList, String status) {
        GameListResponseDTO response = new GameListResponseDTO();
        response.setData(gameList);
        response.setStatus(status);
        return response;
    }
}
