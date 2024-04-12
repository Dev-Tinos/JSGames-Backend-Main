package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteFriend {
    private final FriendDeleteSmallBean friendDeleteSmallBean;
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public StateResponseDTO exec(FriendRequestDTO friendRequestDTO) {
        UserDAO userDAO = userGetByIdSmallBean.exec(friendRequestDTO.getUserId());
        UserDAO friendDAO = userGetByEmailSmallBean.exec(friendRequestDTO.getFriendEmail());
        return friendDeleteSmallBean.exec(userDAO, friendDAO);
    }
}
