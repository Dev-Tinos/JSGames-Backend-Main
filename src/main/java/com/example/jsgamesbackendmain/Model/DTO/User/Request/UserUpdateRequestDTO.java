package com.example.jsgamesbackendmain.Model.DTO.User.Request;


import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter @Setter
public class UserUpdateRequestDTO {
    private String userId;
    private String nickname;
    private String email;
    private MultipartFile profileImage;
    private Major major;
}
