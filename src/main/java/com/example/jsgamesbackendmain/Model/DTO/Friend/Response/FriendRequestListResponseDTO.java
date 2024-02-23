package com.example.jsgamesbackendmain.Model.DTO.Friend.Response;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendRequestState;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class FriendRequestListResponseDTO {
    private String friendEmail;
    private String friendName;
    private String friendProfile;
    private FriendRequestState friendStatus;
    private LocalDateTime createdAt;
    
}
