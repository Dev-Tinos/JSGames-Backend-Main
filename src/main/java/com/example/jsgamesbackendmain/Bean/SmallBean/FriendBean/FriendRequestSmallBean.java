package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestSmallBean {
    private final FriendRequestRepository friendRequestRepository;


    public StateResponseDTO exec(String userId, String friendId) {
        FriendRequestDAO friendRequestDAO = FriendRequestDAO.builder()
                .userId(userId)
                .friendId(friendId)
                .build();
        friendRequestRepository.save(friendRequestDAO);
        return StateResponseDTO.builder()
                .state(true)
                .build();
    }
}
