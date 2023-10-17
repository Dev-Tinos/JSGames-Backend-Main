package com.example.jsgamesbackendmain.Model.DTO.User;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignUpRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private String major;
    private String code;
}
