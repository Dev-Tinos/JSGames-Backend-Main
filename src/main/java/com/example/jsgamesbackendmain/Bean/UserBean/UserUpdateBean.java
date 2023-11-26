package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.S3Bean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class UserUpdateBean {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserGetSmallBean userGetSmallBean;

    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private S3DeleteSmallBeam S3DeleteSmallBeam;
    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) throws IOException {

        UserDAO user = userGetSmallBean.getUser(userUpdateRequestDTO.getUserId());
        if(userUpdateRequestDTO.getNickname() != null) {
            user.setNickname(userUpdateRequestDTO.getNickname());
        }
        if(userUpdateRequestDTO.getMajor() != null) {
            user.setMajor(userUpdateRequestDTO.getMajor());
        }
        if(userUpdateRequestDTO.getProfileImageURL() != null) {
            S3DeleteSmallBeam.exec(user.getProfileImageURL());
            user.setProfileImageURL(
                    userUpdateRequestDTO.getProfileImageURL());
        }
        return mapperBean.to(userRepository.save(user), UserUpdateResponseDTO.class);
    }
}