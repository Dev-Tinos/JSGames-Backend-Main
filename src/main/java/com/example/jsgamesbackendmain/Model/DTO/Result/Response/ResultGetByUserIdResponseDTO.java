package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultGetByUserIdResponseDTO extends ResultGetResponse {
    private Long userId;

    public static ResultGetByUserIdResponseDTO of(ResultDAO resultDAO) {
        ResultGetByUserIdResponseDTO resultGetByUserIdResponseDTO = new ResultGetByUserIdResponseDTO();

        ResultGetResponse.mapFromDAO(resultGetByUserIdResponseDTO, resultDAO);

        resultGetByUserIdResponseDTO.setUserId(resultDAO.getUserId());

        return resultGetByUserIdResponseDTO;
    }
}
