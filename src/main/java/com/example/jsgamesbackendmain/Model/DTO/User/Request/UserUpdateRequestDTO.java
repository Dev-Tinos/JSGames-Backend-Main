package com.example.jsgamesbackendmain.Model.DTO.User.Request;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserUpdateRequestDTO {
    private String userId;
    private String nickname;
    private String email;
    private String imageUrl;
    private Major major;
}
