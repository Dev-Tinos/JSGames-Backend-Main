package com.example.jsgamesbackendmain.Model.DTO.User.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginRequestDTO {
    private String email;
    private String password;
}
