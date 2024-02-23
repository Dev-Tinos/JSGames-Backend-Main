package com.example.jsgamesbackendmain.Bean.FriendBean;

import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Request.FriendRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Friend.Response.FriendRequestListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendRequestState;
import com.example.jsgamesbackendmain.Repository.FriendRepository;
import com.example.jsgamesbackendmain.Repository.FriendRequestRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class FriendBeanTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendRepository friendRepository;
    @Autowired
    private FriendRequestRepository friendRequestRepository;
    @Autowired
    private FriendRequestListBean friendRequestListBean;
    @Autowired
    private FriendRequestedListBean friendRequestedListBean;
    @Autowired
    private FriendListBean friendListBean;

    @Autowired
    private FriendRequestBean friendRequestBean;
    @Test
    void FriendRequestBeanTest() {
        //given
        UserDAO userDAO = UserDAO.builder()
                .userId("1")
                .email("email")
                .build();
        userRepository.save(userDAO);
        UserDAO friendDAO = UserDAO.builder()
                .userId("2")
                .email("friendEmail")
                .build();
        userRepository.save(friendDAO);


        FriendRequestDTO friendRequestDTO = FriendRequestDTO.builder()
                .userId("1")
                .friendEmail("friendEmail")
                .build();
        //when
        friendRequestBean.exec(friendRequestDTO);
        //then
        assertEquals(friendRequestListBean.exec("1", 0, 5).get(0).getCreatedAt(), friendRequestedListBean.exec("2", 0, 5).get(0).getCreatedAt());
    }

    @Autowired
    private FriendRequestAcceptBean friendRequestAcceptBean;
    @Test
    void FriendRequestAcceptBeanTest() {
        //given
        UserDAO userDAO = UserDAO.builder()
                .userId("1")
                .email("email")
                .build();
        userRepository.save(userDAO);
        UserDAO friendDAO = UserDAO.builder()
                .userId("2")
                .email("friendEmail")
                .build();
        userRepository.save(friendDAO);
        UserDAO friendDAO1 = UserDAO.builder()
                .userId("3")
                .email("friendEmail1")
                .build();
        userRepository.save(friendDAO1);

        FriendRequestDTO friendRequestDTO = FriendRequestDTO.builder()
                .userId("1")
                .friendEmail("friendEmail")
                .build();
        friendRequestBean.exec(friendRequestDTO);
        FriendRequestDTO friendRequestDTO2 = FriendRequestDTO.builder()
                .userId("2")
                .friendEmail("email")
                .build();
        //when
        friendRequestAcceptBean.exec(friendRequestDTO2);
        //then
        assertEquals(friendRepository.count(), 2);
    }

    @Autowired
    private FriendRequestRejectionBean friendRequestRejectionBean;
    @Test
    void FriendRequestRejectionBeanTest() {
        //given
        UserDAO userDAO = UserDAO.builder()
                .userId("1")
                .email("email")
                .build();
        userRepository.save(userDAO);
        UserDAO friendDAO = UserDAO.builder()
                .userId("2")
                .email("friendEmail")
                .build();
        userRepository.save(friendDAO);


        FriendRequestDTO friendRequestDTO = FriendRequestDTO.builder()
                .userId("1")
                .friendEmail("friendEmail")
                .build();
        friendRequestBean.exec(friendRequestDTO);
        FriendRequestDTO friendRequestDTO2 = FriendRequestDTO.builder()
                .userId("3")
                .friendEmail("email")
                .build();
        //when
        friendRequestRejectionBean.exec(friendRequestDTO2);

        //then
        //assertEquals(friendRequestListBean.exec("1", 0, 5).get(0).getFriendStatus(), FriendRequestState.REJECTED);
    }

    @Autowired
    private FriendRequestDeleteBean friendRequestDeleteBean;
    @Test
    void FriendRequestDeleteBeanTest() {
        //given
        UserDAO userDAO = UserDAO.builder()
                .userId("1")
                .email("email")
                .build();
        userRepository.save(userDAO);
        UserDAO friendDAO = UserDAO.builder()
                .userId("2")
                .email("friendEmail")
                .build();
        userRepository.save(friendDAO);


        FriendRequestDTO friendRequestDTO = FriendRequestDTO.builder()
                .userId("1")
                .friendEmail("friendEmail")
                .build();
        friendRequestBean.exec(friendRequestDTO);
        //when
        friendRequestDeleteBean.exec(friendRequestDTO);
        //then
        assertEquals(friendRequestListBean.exec("1", 0, 5).size(), 0);
    }

    @Autowired
    private FriendDeleteBean friendDeleteBean;
    @Test
    void FriendDeleteBeanTest() {
        //given
        UserDAO userDAO = UserDAO.builder()
                .userId("1")
                .email("email")
                .build();
        userRepository.save(userDAO);
        UserDAO friendDAO = UserDAO.builder()
                .userId("2")
                .email("friendEmail")
                .build();
        userRepository.save(friendDAO);


        FriendRequestDTO friendRequestDTO = FriendRequestDTO.builder()
                .userId("1")
                .friendEmail("friendEmail")
                .build();
        friendRequestBean.exec(friendRequestDTO);
        FriendRequestDTO friendRequestDTO2 = FriendRequestDTO.builder()
                .userId("2")
                .friendEmail("email")
                .build();
        friendRequestAcceptBean.exec(friendRequestDTO2);
        //when
        friendDeleteBean.exec(friendRequestDTO);
        //then
        assertEquals(friendRepository.count(), 0);
    }
}
