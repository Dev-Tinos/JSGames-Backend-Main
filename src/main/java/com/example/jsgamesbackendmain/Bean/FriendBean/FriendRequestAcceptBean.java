package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendFindSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FriendRequestAcceptBean {
    private final FriendRequestDeleteSmallBean friendRequestDeleteSmallBean;
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final FriendSaveSmallBean friendSaveSmallBean;
    private final FriendFindSmallBean friendFindSmallBean;

    public StateResponseDTO exec(FriendRequestDTO friendRequestDTO) {
        UserDAO user = userGetByIdSmallBean.exec(friendRequestDTO.getUserId());
        UserDAO friend = userGetByEmailSmallBean.exec(friendRequestDTO.getFriendEmail());
        friendFindSmallBean.exec(friend.getUserId(), user.getUserId());
        friendRequestDeleteSmallBean.exec(friend.getUserId(), friendRequestDTO.getUserId());
        friendSaveSmallBean.exec(user, friend);
        friendSaveSmallBean.exec(friend, user);

        return StateResponseDTO.builder().state(true).build();
    }
}
