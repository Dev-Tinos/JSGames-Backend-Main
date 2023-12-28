package com.example.jsgamesbackendmain.Model.DTO.User.Request;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRequestDTO {
    private String email;
    private String password;

    public static UserLoginRequestDTO of(UserDAO userDAO) {
        return UserLoginRequestDTO.builder()
                .email(userDAO.getEmail())
                .password(userDAO.getPassword())
                .build();
    }
}
