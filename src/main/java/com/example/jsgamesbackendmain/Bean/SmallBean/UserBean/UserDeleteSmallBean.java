package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteSmallBean {
    private final UserRepository userRepository;

    public void exec(UserDAO user) {
        userRepository.delete(user);
    }
}
