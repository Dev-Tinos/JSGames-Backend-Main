package com.example.jsgamesbackendmain.Model.DTO.User;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String password;
    private String major;
    public static UserDTO of(UserDAO userDAO) {
        UserDTO userGetDTO = new UserDTO();
        userGetDTO.setUserId(userDAO.getUserId());
        userGetDTO.setNickname(userDAO.getNickname());
        userGetDTO.setEmail(userDAO.getEmail());
        userGetDTO.setPassword(userDAO.getPassword());
        userGetDTO.setMajor(userDAO.getMajor());
        return userGetDTO;
    }
}
