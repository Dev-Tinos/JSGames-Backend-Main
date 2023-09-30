package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetResponseDTO {

    private Long resultId;
    private Long userId;
    private Long gameId;
    private Double gameScore;

    public static ResultGetResponseDTO of(ResultDAO resultDAO) {
        ResultGetResponseDTO resultGetResponseDTO = new ResultGetResponseDTO();
        resultGetResponseDTO.setResultId(resultDAO.getResultId());
        resultGetResponseDTO.setUserId(resultDAO.getUserId());
        resultGetResponseDTO.setGameId(resultDAO.getGameId());
        resultGetResponseDTO.setGameScore(resultDAO.getGameScore());

        return resultGetResponseDTO;
    }
}
