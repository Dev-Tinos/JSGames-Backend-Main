package com.example.jsgamesbackendmain.Model.DTO.Friend.Response;

import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Builder
public class FriendListResponseDTO {
    private String friendEmail;
    private String friendName;
    private String friendProfile;
    private ParentMajor parentMajor;
    private Major major;
    private LocalDateTime createdAt;
    private LocalDateTime recentPlay;
}
