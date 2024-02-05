package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.FriendBean.*;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final FriendRequestBean friendRequestBean;
    private final FriendRequestListBean friendRequestListBean;
    private final FriendRequestedListBean friendRequestedListBean;
    private final FriendRequestDeleteBean friendRequestDeleteBean;
    private final FriendRequestRejectionBean friendRequestRejectionBean;
    private final FriendRequestAcceptBean friendRequestAcceptBean;
    private final FriendDeleteBean friendDeleteBean;
    private final FriendListBean friendListBean;

    public StateResponseDTO requestFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestBean.exec(friendRequestDTO);
    }
    
    public List<FriendRequestListResponseDTO> requestList(String userId, Integer page, Integer size) {
        return friendRequestListBean.exec(userId, page, size);
    }

    public List<FriendRequestListResponseDTO> requestedList(String userId, Integer page, Integer size) {
        return friendRequestedListBean.exec(userId, page, size);
    }

    public StateResponseDTO deleteRequest(FriendRequestDTO friendRequestDTO) {
        return friendRequestDeleteBean.exec(friendRequestDTO);
    }

    public StateResponseDTO rejectFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestRejectionBean.exec(friendRequestDTO);
    }

    public StateResponseDTO acceptFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestAcceptBean.exec(friendRequestDTO);
    }

    public StateResponseDTO deleteFriend(FriendRequestDTO friendRequestDTO) {
        return friendDeleteBean.exec(friendRequestDTO);
    }

    public List<FriendListResponseDTO> friendList(String userId, Integer page, Integer size, FriendSort sort) {
        return friendListBean.exec(userId, page, size, sort);
    }
}
