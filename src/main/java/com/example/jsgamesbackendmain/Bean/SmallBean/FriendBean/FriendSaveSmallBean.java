package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendSaveSmallBean {
    private final FriendRepository friendRepository;

    public void exec(UserDAO user, UserDAO friend) {
        FriendDAO friendDAO = FriendDAO.builder()
                .user(user)
                .friend(friend)
                .build();
        friendRepository.save(friendDAO);
    }
}
