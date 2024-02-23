package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendDeleteSmallBean {
    private final FriendRepository friendRepository;

    public StateResponseDTO exec(UserDAO userDAO, UserDAO friendDAO) {
        friendRepository.deleteByUserAndFriend(userDAO, friendDAO);
        friendRepository.deleteByUserAndFriend(friendDAO, userDAO);
        return StateResponseDTO.builder().state(true).build();
    }
}
