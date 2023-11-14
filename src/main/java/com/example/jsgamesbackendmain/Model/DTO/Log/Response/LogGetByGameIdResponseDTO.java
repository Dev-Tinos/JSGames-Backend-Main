package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogGetByGameIdResponseDTO extends LogGetResponse {

    private Long userId;
    public static LogGetByGameIdResponseDTO of(LogDAO logDAO) {
        LogGetByGameIdResponseDTO logGetByGameIdResponseDTO = new LogGetByGameIdResponseDTO();

        LogGetResponse.mapFromDAO(logGetByGameIdResponseDTO, logDAO);

        logGetByGameIdResponseDTO.setUserId(logDAO.getUserId());

        return logGetByGameIdResponseDTO;
    }

}
