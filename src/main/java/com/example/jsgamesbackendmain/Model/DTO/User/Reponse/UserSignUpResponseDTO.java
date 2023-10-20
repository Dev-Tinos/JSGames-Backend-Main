package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignUpResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String major;
    public static UserSignUpResponseDTO of(UserDAO userDAO) {
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        userSignUpResponseDTO.setUserId(userDAO.getUserId());
        userSignUpResponseDTO.setNickname(userDAO.getNickname());
        userSignUpResponseDTO.setEmail(userDAO.getEmail());
        userSignUpResponseDTO.setMajor(userDAO.getMajor());
        return userSignUpResponseDTO;
    }
}
