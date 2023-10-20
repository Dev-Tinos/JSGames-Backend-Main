package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserLoginResponseDTO {
    private Long userId;

    public static UserLoginResponseDTO of(UserDAO userDAO) {
        UserLoginResponseDTO userLoginResponseDTO = new UserLoginResponseDTO();
        userLoginResponseDTO.setUserId(userDAO.getUserId());
        return userLoginResponseDTO;
    }
}
