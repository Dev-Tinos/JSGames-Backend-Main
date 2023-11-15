package com.example.jsgamesbackendmain.Model.DTO.User.Request;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateRequestDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String password;
    private Major major;
    public static UserUpdateRequestDTO of(UserDAO userDAO) {
        UserUpdateRequestDTO userUpdateRequestDTO = new UserUpdateRequestDTO();
        userUpdateRequestDTO.setUserId(userDAO.getUserId());
        userUpdateRequestDTO.setNickname(userDAO.getNickname());
        userUpdateRequestDTO.setEmail(userDAO.getEmail());
        userUpdateRequestDTO.setPassword(userDAO.getPassword());
        userUpdateRequestDTO.setMajor(userDAO.getMajor());
        return userUpdateRequestDTO;
    }
}
