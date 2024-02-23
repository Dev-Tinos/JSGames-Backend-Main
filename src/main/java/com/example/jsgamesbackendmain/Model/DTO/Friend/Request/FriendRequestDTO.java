package com.example.jsgamesbackendmain.Model.DTO.Friend.Request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FriendRequestDTO {
    private String userId;
    private String friendEmail;
}
