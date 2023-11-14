package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString(callSuper = true)
public class LogGetByGameIdUserIdResponseDTO extends LogGetResponse {

    private Long userId;
    public static LogGetByGameIdUserIdResponseDTO of(LogDAO logDAO) {
        LogGetByGameIdUserIdResponseDTO dto = new LogGetByGameIdUserIdResponseDTO();

        LogGetResponse.mapFromDAO(dto, logDAO);

        dto.setUserId(logDAO.getUserId());

        return dto;
    }
}
