package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSaveSmallBean {
    private final UserRepository userRepository;

    public UserDAO exec(UserDAO userDAO) {
        return userRepository.save(userDAO);
    }
}
