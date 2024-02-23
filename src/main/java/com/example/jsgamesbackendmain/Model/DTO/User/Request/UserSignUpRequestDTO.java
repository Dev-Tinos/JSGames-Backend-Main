package com.example.jsgamesbackendmain.Model.DTO.User.Request;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserSignUpRequestDTO {
    private String email;
    private String password;
    private String nickname;
    private Major major;
    @Builder.Default
    private String profileImageURL = "https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png";
    private String code;

    public UserDAO toDAO(String userId, String password, ParentMajor parentMajor) {
        return UserDAO.builder()
                .userId(userId)
                .email(email)
                .password(password)
                .nickname(nickname)
                .parentMajor(parentMajor)
                .major(major)
                .profileImageURL(
                        this.getProfileImageURL() == null ?
                                "https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png" :
                                this.getProfileImageURL()
                )
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
