package com.example.jsgamesbackendmain.Model.DTO.Game.Request;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
public class GameCreateRequestDTO {
    private String gameName;
    private String userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore = 0.0;

    @NotNull(message = "ScoreType는 필수 입력값 입니다.")
    private ScoreType scoreType;

    private String description;

    public GameDAO toDAO() {
        return GameDAO.builder()
                .gameName(this.getGameName())
                .gameImage(this.getImageUrl())
                .gameUrl(this.getGameUrl())
                .targetScore(this.getTargetScore())
                .scoreType(this.getScoreType())
                .viewCount(0L)
                .description(this.getDescription())
                .build();
    }

    public static GameCreateRequestDTO of(GameDAO gameDAO) {
        return GameCreateRequestDTO.builder()
                .gameName(gameDAO.getGameName())
                .userId(gameDAO.getUser().getUserId())
                .imageUrl(gameDAO.getGameImage())
                .gameUrl(gameDAO.getGameUrl())
                .targetScore(gameDAO.getTargetScore())
                .scoreType(gameDAO.getScoreType())
                .description(gameDAO.getDescription())
                .build();
    }

}
