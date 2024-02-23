package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestBean {

    private final FriendRequestSmallBean friendRequestSmallBean;
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;

    public StateResponseDTO exec(FriendRequestDTO friendRequestDTO) {
        String friendId = userGetByEmailSmallBean.exec(friendRequestDTO.getFriendEmail()).getUserId();
        return friendRequestSmallBean.exec(friendRequestDTO.getUserId(), friendId);
    }
}
