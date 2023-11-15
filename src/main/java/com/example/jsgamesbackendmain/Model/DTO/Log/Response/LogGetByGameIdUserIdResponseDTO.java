package com.example.jsgamesbackendmain.Model.DTO.Log.Response;

import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogGetByGameIdUserIdResponseDTO extends LogGetResponse {

    private UserLogResponseDTO user;
}
