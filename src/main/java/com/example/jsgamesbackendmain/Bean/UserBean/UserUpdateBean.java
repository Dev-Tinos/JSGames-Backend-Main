package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserSaveSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateBean {

    @Autowired
    private UserSaveSmallBean userSaveSmallBean;

    @Autowired
    private UserGetByIdSmallBean userGetByIdSmallBean;

    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private MajorMapperBean majorMapperBean;

    @Autowired
    private S3DeleteSmallBeam S3DeleteSmallBeam;
    public UserUpdateResponseDTO exec(UserUpdateRequestDTO userUpdateRequestDTO) {
        UserDAO user = userGetByIdSmallBean.exec(userUpdateRequestDTO.getUserId());

        if(userUpdateRequestDTO.getNickname() != null) {
            user.setNickname(userUpdateRequestDTO.getNickname());
        }
        if(userUpdateRequestDTO.getMajor() != null) {
            user.setMajor(userUpdateRequestDTO.getMajor());
            user.setParentMajor(majorMapperBean.getParentMajor(userUpdateRequestDTO.getMajor()));
        }
        if(userUpdateRequestDTO.getProfileImageURL() != null) {
            S3DeleteSmallBeam.exec(user.getProfileImageURL());
            user.setProfileImageURL(
                    userUpdateRequestDTO.getProfileImageURL());
        }
        return mapperBean.to(userSaveSmallBean.exec(user), UserUpdateResponseDTO.class);
    }
}