package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.FriendBean.*;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final SendFriendRequest friendRequestBean;
    private final GetSentFriendRequests friendRequestListBean;
    private final GetReceivedFriendRequests friendRequestedListBean;
    private final DeleteFriendRequest friendRequestDeleteBean;
    private final RejectionFriendRequest friendRequestRejectionBean;
    private final AcceptFriendRequest friendRequestAcceptBean;
    private final DeleteFriend friendDeleteBean;
    private final GetFriends friendListBean;

    @Transactional
    public StateResponseDTO requestFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestBean.exec(friendRequestDTO);
    }

    @Transactional(readOnly = true)
    public List<FriendRequestListResponseDTO> requestList(String userId, Integer page, Integer size) {
        return friendRequestListBean.exec(userId, page, size);
    }

    @Transactional(readOnly = true)
    public List<FriendRequestListResponseDTO> requestedList(String userId, Integer page, Integer size) {
        return friendRequestedListBean.exec(userId, page, size);
    }

    @Transactional
    public StateResponseDTO deleteRequest(FriendRequestDTO friendRequestDTO) {
        return friendRequestDeleteBean.exec(friendRequestDTO);
    }

    @Transactional
    public StateResponseDTO rejectFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestRejectionBean.exec(friendRequestDTO);
    }

    @Transactional
    public StateResponseDTO acceptFriend(FriendRequestDTO friendRequestDTO) {
        return friendRequestAcceptBean.exec(friendRequestDTO);
    }

    @Transactional
    public StateResponseDTO deleteFriend(FriendRequestDTO friendRequestDTO) {
        return friendDeleteBean.exec(friendRequestDTO);
    }

    @Transactional(readOnly = true)
    public List<FriendListResponseDTO> friendList(String userId, Integer page, Integer size, FriendSort sort) {
        return friendListBean.exec(userId, page, size, sort);
    }
}
