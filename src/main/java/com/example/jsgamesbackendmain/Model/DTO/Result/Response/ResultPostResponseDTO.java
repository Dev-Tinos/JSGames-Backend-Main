package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultPostResponseDTO {

    private Long resultId;
    private Long userId;
    private Long gameId;
    private Double gameScore;

    public static ResultPostResponseDTO of(ResultDAO resultDAO) {
        ResultPostResponseDTO resultPostResponseDTO = new ResultPostResponseDTO();
        resultPostResponseDTO.setResultId(resultDAO.getResultId());
        resultPostResponseDTO.setUserId(resultDAO.getUserId());
        resultPostResponseDTO.setGameId(resultDAO.getGameId());
        resultPostResponseDTO.setGameScore(resultDAO.getGameScore());

        return resultPostResponseDTO;
    }
}
