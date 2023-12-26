package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginResponseDTO {
    private String userId;

    public static UserLoginResponseDTO of(UserDAO userDAO) {
        return UserLoginResponseDTO.builder()
                .userId(userDAO.getUserId())
                .build();
    }
}
