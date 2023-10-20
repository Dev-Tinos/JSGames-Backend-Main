package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGetResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String major;
    public static UserGetResponseDTO of(UserDAO userDAO) {
        UserGetResponseDTO userGetResponseDTO = new UserGetResponseDTO();
        userGetResponseDTO.setUserId(userDAO.getUserId());
        userGetResponseDTO.setNickname(userDAO.getNickname());
        userGetResponseDTO.setEmail(userDAO.getEmail());
        userGetResponseDTO.setMajor(userDAO.getMajor());
        return userGetResponseDTO;
    }
}
