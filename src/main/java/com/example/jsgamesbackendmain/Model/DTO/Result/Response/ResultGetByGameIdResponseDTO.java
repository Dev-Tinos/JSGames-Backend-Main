package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetByGameIdResponseDTO extends ResultGetResponse {

    private Long userId;
    public static ResultGetByGameIdResponseDTO of(ResultDAO resultDAO) {
        ResultGetByGameIdResponseDTO resultGetByGameIdResponseDTO = new ResultGetByGameIdResponseDTO();

        ResultGetResponse.mapFromDAO(resultGetByGameIdResponseDTO, resultDAO);

        resultGetByGameIdResponseDTO.setUserId(resultDAO.getUserId());

        return resultGetByGameIdResponseDTO;
    }

}
