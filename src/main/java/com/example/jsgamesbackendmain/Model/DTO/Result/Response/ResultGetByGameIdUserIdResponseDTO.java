package com.example.jsgamesbackendmain.Model.DTO.Result.Response;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString(callSuper = true)
public class ResultGetByGameIdUserIdResponseDTO extends ResultGetResponse {

    private Long userId;
    public static ResultGetByGameIdUserIdResponseDTO of(ResultDAO resultDAO) {
        ResultGetByGameIdUserIdResponseDTO dto = new ResultGetByGameIdUserIdResponseDTO();

        ResultGetResponse.mapFromDAO(dto, resultDAO);

        dto.setUserId(resultDAO.getUserId());

        return dto;
    }
}
