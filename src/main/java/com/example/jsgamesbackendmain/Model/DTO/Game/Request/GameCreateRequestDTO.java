package com.example.jsgamesbackendmain.Model.DTO.Game.Request;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GameCreateRequestDTO {
    private String gameName;
    private String userId;
    private String imageUrl;
    private String gameUrl;
    private Double targetScore = 0.0;

    @NotNull(message = "ScoreType는 필수 입력값 입니다.")
    private ScoreType scoreType;

    private String description;

}
