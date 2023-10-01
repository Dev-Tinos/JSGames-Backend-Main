package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGetBean {
    @Autowired
    private UserGetSmallBean userGetSmallBean;

    public UserGetResponseDTO getUser(Long userId) {
        return UserGetResponseDTO.of(userGetSmallBean.getUser(userId));
    }
}
