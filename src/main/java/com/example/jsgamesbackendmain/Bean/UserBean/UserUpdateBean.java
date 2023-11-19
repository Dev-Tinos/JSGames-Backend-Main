package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserEmailDuplicateSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        userEmailDuplicateSmallBean.exec(userUpdateRequestDTO.getEmail());

        UserDAO user = userGetSmallBean.getUser(userUpdateRequestDTO.getUserId());
        user.setNickname(userUpdateRequestDTO.getNickname());
        user.setEmail(userUpdateRequestDTO.getEmail());
        user.setMajor(userUpdateRequestDTO.getMajor());

        return mapperBean.to(userRepository.save(user), UserUpdateResponseDTO.class);
    }
}
