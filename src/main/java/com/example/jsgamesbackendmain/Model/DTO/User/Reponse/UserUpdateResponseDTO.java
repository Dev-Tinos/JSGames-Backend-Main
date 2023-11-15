package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String password;
    private ParentMajor parentMajor;
    private Major major;
    public static UserUpdateResponseDTO of(UserDAO userDAO) {
        UserUpdateResponseDTO userUpdateResponseDTO = new UserUpdateResponseDTO();
        userUpdateResponseDTO.setUserId(userDAO.getUserId());
        userUpdateResponseDTO.setNickname(userDAO.getNickname());
        userUpdateResponseDTO.setEmail(userDAO.getEmail());
        userUpdateResponseDTO.setPassword(userDAO.getPassword());
        userUpdateResponseDTO.setParentMajor(userDAO.getParentMajor());
        userUpdateResponseDTO.setMajor(userDAO.getMajor());
        return userUpdateResponseDTO;
    }
}
