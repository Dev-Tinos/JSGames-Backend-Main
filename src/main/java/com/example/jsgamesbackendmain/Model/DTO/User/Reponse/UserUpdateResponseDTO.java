package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateResponseDTO {
    private Long userId;
    private String nickname;
    private String email;
    private String password;
    private String major;
    public static UserUpdateResponseDTO of(UserDAO userDAO) {
        UserUpdateResponseDTO userUpdateResponseDTO = new UserUpdateResponseDTO();
        userUpdateResponseDTO.setUserId(userDAO.getUserId());
        userUpdateResponseDTO.setNickname(userDAO.getNickname());
        userUpdateResponseDTO.setEmail(userDAO.getEmail());
        userUpdateResponseDTO.setPassword(userDAO.getPassword());
        userUpdateResponseDTO.setMajor(userDAO.getMajor());
        return userUpdateResponseDTO;
    }
}
