package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestedListSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FriendRequestedListBean {
    private final FriendRequestedListSmallBean friendRequestedListSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public List<FriendRequestListResponseDTO> exec(String userId, Integer page, Integer size) {
        List<FriendRequestDAO> friendRequestDAOS = friendRequestedListSmallBean.exec(userId, page, size);

        return friendRequestDAOS.stream()
                .map(friendRequestDAO -> FriendRequestListResponseDTO.builder()
                        .friendEmail(userGetByIdSmallBean.exec(friendRequestDAO.getUserId()).getEmail())
                        .friendName(userGetByIdSmallBean.exec(friendRequestDAO.getUserId()).getNickname())
                        .friendProfile(userGetByIdSmallBean.exec(friendRequestDAO.getUserId()).getProfileImageURL())
                        .friendStatus(friendRequestDAO.getState())
                        .createdAt(friendRequestDAO.getCreatedAt())
                        .build())
                .collect(Collectors.toList());
    }
}
