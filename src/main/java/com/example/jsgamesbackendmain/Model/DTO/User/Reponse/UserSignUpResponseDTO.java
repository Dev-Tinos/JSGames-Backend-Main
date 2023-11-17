package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserSignUpResponseDTO {
    private String userId;
    private String nickname;
    private String email;
    private ParentMajor parentMajor;
    private Major major;
}
