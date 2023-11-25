package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;


import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserUpdateResponseDTO {
    private String userId;
    private String nickname;
    private String email;
    private String profileImageURL;
    private ParentMajor parentMajor;
    private Major major;
}
