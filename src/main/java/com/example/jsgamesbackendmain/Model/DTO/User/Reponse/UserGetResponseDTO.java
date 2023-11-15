package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserGetResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private ParentMajor parentMajor;
    private Major major;
    public static UserGetResponseDTO of(UserDAO userDAO) {
        UserGetResponseDTO userGetResponseDTO = new UserGetResponseDTO();
        userGetResponseDTO.setUserId(userDAO.getUserId());
        userGetResponseDTO.setNickname(userDAO.getNickname());
        userGetResponseDTO.setEmail(userDAO.getEmail());
        userGetResponseDTO.setParentMajor(userDAO.getParentMajor());
        userGetResponseDTO.setMajor(userDAO.getMajor());
        return userGetResponseDTO;
    }
}
