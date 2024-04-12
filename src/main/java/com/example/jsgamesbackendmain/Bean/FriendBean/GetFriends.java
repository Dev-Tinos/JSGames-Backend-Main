package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendListByRecentSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendListByTimeSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetFriends {
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final FriendListByRecentSmallBean friendListByRecentSmallBean;
    private final FriendListByTimeSmallBean friendListByTimeSmallBean;

    public List<FriendListResponseDTO> exec(String userId, Integer page, Integer size, FriendSort sort) {
        UserDAO user = userGetByIdSmallBean.exec(userId);
        List<FriendListResponseDTO> friendListResponseDTOS;
        if (sort == FriendSort.RECENT) {
            friendListResponseDTOS = friendListByRecentSmallBean.exec(user, page, size);
        } else {
            friendListResponseDTOS = friendListByTimeSmallBean.exec(user, page, size);
        }

        return friendListResponseDTOS;
    }
}
