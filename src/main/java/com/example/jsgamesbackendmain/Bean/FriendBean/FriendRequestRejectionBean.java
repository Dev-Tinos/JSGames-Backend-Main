package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestRejectionSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestRejectionBean {
    private final FriendRequestRejectionSmallBean friendRequestRejectionSmallBean;
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;

    public StateResponseDTO exec(FriendRequestDTO friendRequestDTO) {
        return friendRequestRejectionSmallBean.exec(friendRequestDTO.getUserId(), userGetByEmailSmallBean.exec(friendRequestDTO.getFriendEmail()).getUserId());
    }
}
