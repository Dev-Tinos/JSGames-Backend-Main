package com.example.jsgamesbackendmain.Model.DTO.User.Reponse;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import com.example.jsgamesbackendmain.Model.ENUM.UserRole;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class UserSearchByNicknameResponseDTO {
    private String userId;
    private String nickname;
    private String profileImageURL;
    private ParentMajor parentMajor;
    private Major major;
    private UserRole role;
    private LocalDateTime lastPlayTime;

    public static UserSearchByNicknameResponseDTO of(UserDAO userDAO) {
        return UserSearchByNicknameResponseDTO.builder()
                .userId(userDAO.getUserId())
                .nickname(userDAO.getNickname())
                .profileImageURL(userDAO.getProfileImageURL())
                .parentMajor(userDAO.getParentMajor())
                .major(userDAO.getMajor())
                .role(userDAO.getUserRole())
                .lastPlayTime(userDAO.getLastPlayTime())
                .build();
    }
}
