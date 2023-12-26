package com.example.jsgamesbackendmain.Bean.UesrBean;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
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
public class UserBeanTest {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserSignUpBean userSignUpBean;
    @Test
    void UserCreateBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        UserSignUpRequestDTO requestDTO = UserSignUpRequestDTO.of(user);

        UserSignUpResponseDTO responseDTO = null;
        int a = 1;
        //when
        try {
            responseDTO = userSignUpBean.signUpUser(requestDTO);
        } catch (InvalidException e) {
            //then
            // InvalidException 발생시 통과
            a = 0;
        }
        assertEquals(0, a);
    }

    @Autowired
    private UserDeleteBean userDeleteBean;
    @Test
    void UserDeleteBean() {
        //given
        UserDAO user = UserDAO.createTest(0);

        userRepository.save(user);

        //when
        userDeleteBean.exec(user.getUserId());

        //then
        assertEquals(0, userRepository.findAll().size());
    }

    @Autowired
    private UserGetBean userGetBean;
    @Test
    void UserGetBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);
        UserDAO findDao = userRepository.findById(user.getUserId())
                .get();
        //when
        UserGetResponseDTO dto = userGetBean.exec(user.getUserId());

        //then
        assertEquals(findDao.getUserId(), dto.getUserId());
    }

    @Autowired
    private UserLoginBean userLoginBean;
    @Test
    void UserLoginBeanTest() {
        //given
        UserLoginRequestDTO requestDTO = UserLoginRequestDTO.builder()
                .email("1")
                .password("1")
                .build();

        int a = 0;
        //when
        try {
            userLoginBean.exec(requestDTO);
        }catch (InvalidException e){
            //then
            // InvalidException 발생시 통과
            a = 1;
        }

        assertEquals(1, a);
    }

    @Autowired
    private UserUpdateBean userUpdateBean;
    @Test
    void UserUpdateBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);


        UserDAO userDAO = UserDAO.createTest(1);

        UserUpdateRequestDTO requestDTO = UserUpdateRequestDTO.builder()
                // userId만 같게 해준다.
                .userId(user.getUserId())
                .nickname(userDAO.getNickname())
                .profileImageURL(userDAO.getProfileImageURL())
                .major(userDAO.getMajor())
                .build();


        //when
        UserUpdateResponseDTO responseDTO = userUpdateBean.exec(requestDTO);
        UserDAO expect = userRepository.findAll().stream().findAny().get();

        //then
        assertEquals(expect.getEmail(), responseDTO.getEmail());
    }
}
