package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendRequestState;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestRejectionSmallBean {
    private final FriendRequestRepository friendRequestRepository;

    public StateResponseDTO exec(String userId, String friendId) {
        //FriendRequestDAO의 State를 REJECTED로 변경
        friendRequestRepository.updateStateByUserIdAndFriendId(userId, friendId, FriendRequestState.REJECTED);

        return StateResponseDTO.builder().state(true).build();
    }
}
