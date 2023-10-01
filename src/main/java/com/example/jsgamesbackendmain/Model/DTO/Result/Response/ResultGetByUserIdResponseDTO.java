package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetByUserIdResponseDTO {
    private Long resultId;
    private Long gameId;
    private Double gameScore;
}
