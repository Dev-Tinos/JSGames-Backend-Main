package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSignUpResponseDTO {
    private String userId;
    private String nickname;
    private String email;
    private String profileImageURL;
    private ParentMajor parentMajor;
    private Major major;

    public static UserSignUpResponseDTO of(UserDAO userDAO) {
        return UserSignUpResponseDTO.builder()
                .userId(userDAO.getUserId())
                .nickname(userDAO.getNickname())
                .email(userDAO.getEmail())
                .profileImageURL(userDAO.getProfileImageURL())
                .parentMajor(userDAO.getParentMajor())
                .major(userDAO.getMajor())
                .build();
    }
}
