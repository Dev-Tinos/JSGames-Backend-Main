package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetByUserIdResponseDTO {
    private Long resultId;
    private Long userId;
    private Long gameId;
    private Double gameScore;

    public static ResultGetByUserIdResponseDTO of(ResultDAO resultDAO) {
        ResultGetByUserIdResponseDTO resultGetByUserIdResponseDTO = new ResultGetByUserIdResponseDTO();
        resultGetByUserIdResponseDTO.setResultId(resultDAO.getResultId());
        resultGetByUserIdResponseDTO.setUserId(resultDAO.getUserId());
        resultGetByUserIdResponseDTO.setGameId(resultDAO.getGameId());
        resultGetByUserIdResponseDTO.setGameScore(resultDAO.getGameScore());

        return resultGetByUserIdResponseDTO;
    }
}
