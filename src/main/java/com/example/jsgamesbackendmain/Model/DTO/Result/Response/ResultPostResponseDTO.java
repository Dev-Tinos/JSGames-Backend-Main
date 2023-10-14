package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultPostResponseDTO extends ResultGetResponse {

    private Long userId;

    public static ResultPostResponseDTO of(ResultDAO resultDAO) {
        ResultPostResponseDTO resultPostResponseDTO = new ResultPostResponseDTO();

        ResultGetResponse.mapFromDAO(resultPostResponseDTO, resultDAO);

        resultPostResponseDTO.setUserId(resultDAO.getUserId());

        return resultPostResponseDTO;
    }
}
