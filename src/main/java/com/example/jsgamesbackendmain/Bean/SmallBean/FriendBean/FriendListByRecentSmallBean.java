package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FriendListByRecentSmallBean {
    private final FriendRepository friendRepository;

    public List<FriendListResponseDTO> exec(UserDAO user, Integer page, Integer size) {
        // 페이지와 크기를 이용하여 pageable 객체 생성
        Pageable pageable = PageRequest.of(page, size);

        // 현재 사용자의 친구 목록 가져오기
        List<FriendDAO> friendDAOS = friendRepository.findFriendsByUserIdSortedByLastPlayTime(user.getUserId(), pageable).toList();

        // 각 친구의 최근 게임 플레이 시간을 찾고 정렬하기
        return friendDAOS.stream().map(friendDAO -> FriendListResponseDTO.builder()
                .friendId(friendDAO.getFriend().getUserId())
                .friendEmail(friendDAO.getFriend().getEmail())
                .friendName(friendDAO.getFriend().getNickname())
                .friendProfile(friendDAO.getFriend().getProfileImageURL())
                .parentMajor(friendDAO.getFriend().getParentMajor())
                .major(friendDAO.getFriend().getMajor())
                .createdAt(friendDAO.getCreatedAt())
                .recentPlay(friendDAO.getFriend().getLastPlayTime())
                .build()).collect(Collectors.toList());
    }
}
