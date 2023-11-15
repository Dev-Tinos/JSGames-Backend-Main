package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserSignUpResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private ParentMajor parentMajor;
    private Major major;
    public static UserSignUpResponseDTO of(UserDAO userDAO) {
        UserSignUpResponseDTO userSignUpResponseDTO = new UserSignUpResponseDTO();
        userSignUpResponseDTO.setUserId(userDAO.getUserId());
        userSignUpResponseDTO.setNickname(userDAO.getNickname());
        userSignUpResponseDTO.setEmail(userDAO.getEmail());
        userSignUpResponseDTO.setParentMajor(userDAO.getParentMajor());
        userSignUpResponseDTO.setMajor(userDAO.getMajor());
        return userSignUpResponseDTO;
    }
}
