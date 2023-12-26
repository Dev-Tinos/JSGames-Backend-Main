package com.example.jsgamesbackendmain.Model.DTO.User.Request;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private Major major;
    private String profileImageURL;
    private String code;

    public UserDAO toDAO() {
        return UserDAO.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .major(major)
                .profileImageURL(profileImageURL)
                .build();
    }

    public static UserSignUpRequestDTO of(UserDAO userDAO) {
        return UserSignUpRequestDTO.builder()
                .email(userDAO.getEmail())
                .password(userDAO.getPassword())
                .nickname(userDAO.getNickname())
                .major(userDAO.getMajor())
                .profileImageURL(userDAO.getProfileImageURL())
                .build();
    }
}
