package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendListResponseDTO;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FriendListByTimeSmallBean {
    private final FriendRepository friendRepository;

    public List<FriendListResponseDTO> exec(UserDAO user, Integer page, Integer size) {
        List<FriendDAO> friendDAOS = friendRepository.findByUserOrderByCreatedAtDesc(user, PageRequest.of(page, size)).toList();

        return friendDAOS.stream().map(friendDAO -> FriendListResponseDTO.builder()
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
