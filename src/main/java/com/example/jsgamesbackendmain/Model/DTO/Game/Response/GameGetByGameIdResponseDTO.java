package com.example.jsgamesbackendmain.Model.DTO.Game.Response;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GameGetByGameIdResponseDTO {
    private Long gameId;
    private String gameName;
    private Long userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;
    private Long viewCount;
}

