package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Token.TokenResponseDTO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDTO {
    private String userId;
    private TokenResponseDTO token;

    public static UserLoginResponseDTO of(UserDAO userDAO, TokenResponseDTO token) {
        return UserLoginResponseDTO.builder()
                .userId(userDAO.getUserId())
                .token(token)
                .build();
    }
}
