package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestDeleteSmallBean {
    private final FriendRequestRepository friendRequestRepository;

    public StateResponseDTO exec(String userId, String friendId) {
        friendRequestRepository.deleteByUserIdAndFriendId(userId, friendId);
        return StateResponseDTO.builder().state(true).build();
    }
}
