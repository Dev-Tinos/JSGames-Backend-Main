package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class FriendRequestListSmallBean {
    private final FriendRequestRepository friendRequestRepository;
    
    public List<FriendRequestDAO> exec(String userId, Integer page, Integer size) {
        PageRequest request = PageRequest.of(page, size);
        Page<FriendRequestDAO> friendRequestDAOS = friendRequestRepository.findByUserIdOrderByCreatedAtDesc(userId, request);
        return friendRequestDAOS.toList();
    }
}
