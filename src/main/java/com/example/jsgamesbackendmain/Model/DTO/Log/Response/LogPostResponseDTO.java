package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogPostResponseDTO extends LogGetResponse {

    private Long userId;

    public static LogPostResponseDTO of(LogDAO logDAO) {
        LogPostResponseDTO logPostResponseDTO = new LogPostResponseDTO();

        LogGetResponse.mapFromDAO(logPostResponseDTO, logDAO);

        logPostResponseDTO.setUserId(logDAO.getUserId());

        return logPostResponseDTO;
    }
}
