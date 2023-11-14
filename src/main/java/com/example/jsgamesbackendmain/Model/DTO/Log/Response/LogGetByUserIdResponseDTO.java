package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogGetByUserIdResponseDTO extends LogGetResponse {
    private Long userId;

    public static LogGetByUserIdResponseDTO of(LogDAO logDAO) {
        LogGetByUserIdResponseDTO logGetByUserIdResponseDTO = new LogGetByUserIdResponseDTO();

        LogGetResponse.mapFromDAO(logGetByUserIdResponseDTO, logDAO);

        logGetByUserIdResponseDTO.setUserId(logDAO.getUserId());

        return logGetByUserIdResponseDTO;
    }
}
