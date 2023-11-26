package com.example.jsgamesbackendmain.Model.DTO.User.Request;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class UserSignUpRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private Major major;
    private String profileImageURL;
    private String code;
}
