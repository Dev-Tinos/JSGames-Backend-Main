package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserImageUpdateSmallBean;
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
    private UserEmailDuplicateSmallBean userEmailDuplicateSmallBean;

    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private UserImageUpdateSmallBean userImageUpdateBean;
    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) throws IOException {
        userEmailDuplicateSmallBean.exec(userUpdateRequestDTO.getEmail());

        UserDAO user = userGetSmallBean.getUser(userUpdateRequestDTO.getUserId());
        if(userUpdateRequestDTO.getEmail() != null) {
            user.setEmail(userUpdateRequestDTO.getEmail());
        }
        if(userUpdateRequestDTO.getNickname() != null) {
            user.setNickname(userUpdateRequestDTO.getNickname());
        }
        if(userUpdateRequestDTO.getMajor() != null) {
            user.setMajor(userUpdateRequestDTO.getMajor());
        }
        if(userUpdateRequestDTO.getImage() != null) {
            user.setProfileImageURL(
                    userImageUpdateBean.exec(
                            userUpdateRequestDTO.getUserId(),
                            userUpdateRequestDTO.getEmail(),
                            userUpdateRequestDTO.getImage()));
        }
        return mapperBean.to(userRepository.save(user), UserUpdateResponseDTO.class);
    }
}