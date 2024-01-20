package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteBean {

    private final UserGetByIdSmallBean userGetByIdSmallBean;

    private final UserDeleteSmallBean userDeleteSmallBean;

    private final S3DeleteSmallBeam s3DeleteSmallBeam;

    public StateResponseDTO exec(String userId) {

        UserDAO findUser = userGetByIdSmallBean.exec(userId);

        // 기본 이미지인지 확인
        String findUserProfileImageURL = findUser.getProfileImageURL();
        String defaultProfileImageURL = UserDAO.builder().build().getProfileImageURL();

        // 기본 이미지가 아닐 경우 삭제
        boolean isEqual = findUserProfileImageURL.equals(defaultProfileImageURL);

        System.out.println("isEqual = " + isEqual);

        if (!isEqual) {
            s3DeleteSmallBeam.exec(findUserProfileImageURL);
        }

        // 유저 삭제
        userDeleteSmallBean.exec(findUser);
        return new StateResponseDTO(true);
    }
}
