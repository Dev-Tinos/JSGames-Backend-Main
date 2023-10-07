package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetByGameIdResponseDTO {

    private Long resultId;
    private Long gameId;
    private Long userId;
    private Double gameScore;

    public static ResultGetByGameIdResponseDTO of(ResultDAO resultDAO) {
        ResultGetByGameIdResponseDTO resultGetByGameIdResponseDTO = new ResultGetByGameIdResponseDTO();
        resultGetByGameIdResponseDTO.setResultId(resultDAO.getResultId());
        resultGetByGameIdResponseDTO.setUserId(resultDAO.getUserId());
        resultGetByGameIdResponseDTO.setGameId(resultDAO.getGameId());
        resultGetByGameIdResponseDTO.setGameScore(resultDAO.getGameScore());

        return resultGetByGameIdResponseDTO;
    }

}
