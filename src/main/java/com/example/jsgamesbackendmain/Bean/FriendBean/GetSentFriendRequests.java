package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean.FriendRequestListSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetSentFriendRequests {
    private final FriendRequestListSmallBean friendRequestListSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    
    public List<FriendRequestListResponseDTO> exec(String userId, Integer page, Integer size) {
        List<FriendRequestDAO> friendRequestDAOS = friendRequestListSmallBean.exec(userId, page, size);

        
        return friendRequestDAOS.stream()
                .map(friendRequestDAO -> FriendRequestListResponseDTO.builder()
                        .friendId(friendRequestDAO.getFriendId())
                        .friendEmail(userGetByIdSmallBean.exec(friendRequestDAO.getFriendId()).getEmail())
                        .friendName(userGetByIdSmallBean.exec(friendRequestDAO.getFriendId()).getNickname())
                        .friendProfile(userGetByIdSmallBean.exec(friendRequestDAO.getFriendId()).getProfileImageURL())
                        .friendStatus(friendRequestDAO.getState())
                        .createdAt(friendRequestDAO.getCreatedAt())
                        .build())
                .collect(Collectors.toList());

    }
}
