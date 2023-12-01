package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteSmallBean {
    @Autowired
    private UserRepository userRepository;

    public void exec(String userId){
        userRepository.deleteById(userId);
    }
}
