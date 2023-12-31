package com.example.jsgamesbackendmain.Model.DTO.Game;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GameDTO {

    private Long gameId;
    private String gameName;
    private String userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore;
    private ScoreType scoreType;
    private String description;

        public static GameDTO of(GameDAO gameDAO) {
            return GameDTO.builder()
                    .gameId(gameDAO.getGameId())
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
