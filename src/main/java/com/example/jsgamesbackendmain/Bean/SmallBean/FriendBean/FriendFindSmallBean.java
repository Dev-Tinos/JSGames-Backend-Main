package com.example.jsgamesbackendmain.Bean.SmallBean.FriendBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.FailException;
import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FriendFindSmallBean {
    private final FriendRequestRepository friendRequestRepository;

    public void exec(String userId, String friendId) {
        List<FriendRequestDAO> friendRequestDAOS = friendRequestRepository.findByUserIdAndFriendId(userId, friendId);
        if(friendRequestDAOS.stream().anyMatch(friendRequestDAO -> friendRequestDAO.getState().equals("ACCEPTED"))) {
            throw new FailException("헤당 친구요청이 없습니다.");
        }
    }
}
