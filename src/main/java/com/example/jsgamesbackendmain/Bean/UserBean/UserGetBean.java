package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserGetBean {
    @Autowired
    private UserGetSmallBean userGetSmallBean;

    @Autowired
    private MapperBean mapperBean;

    public UserGetResponseDTO getUser(Long userId) {
        return mapperBean.to(userGetSmallBean.getUser(userId), UserGetResponseDTO.class);
    }
}
