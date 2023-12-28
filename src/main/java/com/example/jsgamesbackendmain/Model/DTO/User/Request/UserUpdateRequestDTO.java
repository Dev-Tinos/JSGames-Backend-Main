package com.example.jsgamesbackendmain.Model.DTO.User.Request;


import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdateRequestDTO {
    private String userId;
    private String nickname;
    private String profileImageURL;
    private Major major;

    public static UserUpdateRequestDTO of(UserDAO userDAO) {
        return UserUpdateRequestDTO.builder()
                .userId(userDAO.getUserId())
                .nickname(userDAO.getNickname())
                .profileImageURL(userDAO.getProfileImageURL())
                .major(userDAO.getMajor())
                .build();
    }
}
