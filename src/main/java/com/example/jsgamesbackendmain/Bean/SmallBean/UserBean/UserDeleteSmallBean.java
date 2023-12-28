package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDeleteSmallBean {
    private final UserRepository userRepository;

    public void exec(String userId) {
        userRepository.deleteById(userId);
    }
}
