package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserSaveSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateUser {
    private final UserSaveSmallBean userSaveSmallBean;

    private final UserGetByIdSmallBean userGetByIdSmallBean;

    private final MajorMapperBean majorMapperBean;

    private final S3DeleteSmallBeam S3DeleteSmallBeam;

    public UserUpdateResponseDTO exec(UserUpdateRequestDTO userUpdateRequestDTO) {
        UserDAO user = userGetByIdSmallBean.exec(userUpdateRequestDTO.getUserId());

        if (userUpdateRequestDTO.getProfileImageURL() != null) {
            S3DeleteSmallBeam.exec(user.getProfileImageURL());
        }

        user.update(userUpdateRequestDTO, majorMapperBean.getParentMajor(user.getMajor()));

        return UserUpdateResponseDTO.of(userSaveSmallBean.exec(user));
    }
}