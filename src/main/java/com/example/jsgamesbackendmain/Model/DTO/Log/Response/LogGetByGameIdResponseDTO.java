package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LogGetByGameIdResponseDTO extends LogGetResponse {

    private UserLogResponseDTO user;
}
