package com.example.jsgamesbackendmain.Bean.UesrBean;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSearchByNicknameResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSignUpResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class UserBeanTest {
    @Autowired
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private LogRepository logRepository;
    @Autowired
    private ReviewRepository reviewRepository;


    @Autowired
    private SignUp userSignUpBean;

    @Test
    void UserCreateBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        UserSignUpRequestDTO requestDTO = UserSignUpRequestDTO.of(user);

        UserSignUpResponseDTO responseDTO = null;
        int a = 1;
        //when
        try {
            responseDTO = userSignUpBean.exec(requestDTO);
        } catch (InvalidException e) {
            //then
            // InvalidException 발생시 통과
            a = 0;
        }
        assertEquals(0, a);
    }

    @Autowired
    private DeleteUser userDeleteBean;

    @Test
    void UserDeleteBean() {
        //given
        UserDAO newUser = UserDAO.createTest(0);
        newUser = userRepository.save(newUser);

        GameDAO newGame = GameDAO.createTest(0, newUser);
        gameRepository.save(newGame);

        ReviewDAO newReview = ReviewDAO.createTest(0, newGame, newUser);
        reviewRepository.save(newReview);

        LogDAO newLog = LogDAO.createTest(0, newGame, newUser);
        logRepository.save(newLog);

        // when
        userDeleteBean.exec(newUser.getUserId());

        //then
        assertEquals(0, userRepository.findAll().size());
        assertEquals(0, gameRepository.findAll().size());
        assertEquals(0, reviewRepository.findAll().size());
        assertEquals(0, logRepository.findAll().size());
    }

    @Autowired
    private GetUserByUserId userGetBean;

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
    private Login userLoginBean;

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
        } catch (InvalidException e) {
            //then
            // InvalidException 발생시 통과
            a = 1;
        }

        assertEquals(1, a);
    }

    @Autowired
    private UpdateUser userUpdateBean;

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

    @Autowired
    private GetUsersByName userSearchByNicknameBean;

    @Test
    void UserSearchByNicknameBeanTest() {
        //given
        UserDAO user1 = UserDAO.createTest(0);
        user1.update(UserUpdateRequestDTO.builder()
                .nickname("1")
                .build(), null);
        userRepository.save(user1);

        UserDAO user2 = UserDAO.createTest(2);
        user2.update(UserUpdateRequestDTO.builder()
                .nickname("2")
                .build(), null);
        userRepository.save(user2);

        UserDAO user3 = UserDAO.createTest(11);
        user3.update(UserUpdateRequestDTO.builder()
                .nickname("11")
                .build(), null);
        userRepository.save(user3);

        em.flush();

        //when
        List<UserSearchByNicknameResponseDTO> exec = userSearchByNicknameBean.exec(user1.getNickname(), 0, 10);

        List<UserSearchByNicknameResponseDTO> expect = exec.stream()
                .sorted(
                        Comparator.comparing(UserSearchByNicknameResponseDTO::getLastPlayTime)
                                .thenComparing(UserSearchByNicknameResponseDTO::getUserId)
                ).collect(Collectors.toList());

        em.flush();

        List<UserDAO> actual = userRepository.findAll()
                .stream()
                .filter(user -> user.getNickname().contains(user1.getNickname()))
                .collect(Collectors.toList());


        int size = exec.size();

        //then
        assertEquals(2, size);
        // comparing order expect list and actual list
        for (int i = 0; i < size; i++) {
            assertEquals(expect.get(i).getUserId(), actual.get(i).getUserId());
        }
    }
}
