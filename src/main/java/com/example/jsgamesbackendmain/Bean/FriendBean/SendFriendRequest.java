package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByEmailSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendFriendRequest {

    private final FriendRequestSmallBean friendRequestSmallBean;
    private final UserGetByEmailSmallBean userGetByEmailSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    private final FriendRepository friendRepository;

    public StateResponseDTO exec(FriendRequestDTO friendRequestDTO) {
        String friendId = userGetByEmailSmallBean.exec(friendRequestDTO.getFriendEmail()).getUserId();
        //이미 친구면 에러
        if (friendRepository.existsByUserAndFriend(userGetByIdSmallBean.exec(friendRequestDTO.getUserId()), userGetByIdSmallBean.exec(friendId))) {
            throw new InvalidException("이미 친구 상태입니다.");
        }
        return friendRequestSmallBean.exec(friendRequestDTO.getUserId(), friendId);
    }
}
