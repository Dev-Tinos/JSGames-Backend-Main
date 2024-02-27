package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import com.example.jsgamesbackendmain.Model.ENUM.UserRole;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserGetResponseDTO {
    private String userId;
    private String nickname;
    private String email;
    private String profileImageURL;
    private ParentMajor parentMajor;
    private Major major;
    private UserRole role;

    public static UserGetResponseDTO of(UserDAO userDAO) {
        return UserGetResponseDTO.builder()
                .userId(userDAO.getUserId())
                .nickname(userDAO.getNickname())
                .email(userDAO.getEmail())
                .profileImageURL(userDAO.getProfileImageURL())
                .parentMajor(userDAO.getParentMajor())
                .major(userDAO.getMajor())
                .role(userDAO.getUserRole())
                .build();
    }
}
