package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@RequiredArgsConstructor
public class UserRecentPlayTimeSmallBean {
    private final LogRepository logRepository;

    public LocalDateTime exec(UserDAO user) {
        return logRepository.getRecentPlay(user);
    }
}
