package com.example.jsgamesbackendmain.Bean.HelpfulBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.HelpfulDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.HelpfulRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
public class HelpfulBeanTest {
    @Autowired
    private HelpfulRepository helpfulRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private HelpfulGetBean helpfulGetBean;

    @Test
    void HelpfulGetBeanTest() {
        UserDAO newUser1 = UserDAO.createTest(1);
        userRepository.save(newUser1);

        UserDAO newUser2 = UserDAO.createTest(2);
        newUser2.setUserId("test02");
        userRepository.save(newUser2);

        GameDAO newGame = GameDAO.createTest(1, newUser1);
        gameRepository.save(newGame);

        ReviewDAO newReview = ReviewDAO.createTest(1, newGame, newUser1);
        reviewRepository.save(newReview);

        //given
        HelpfulDAO newHelpful = HelpfulDAO.builder()
                .build();

        newHelpful.setUser(newUser1);
        newHelpful.setReview(newReview);
        helpfulRepository.save(newHelpful);

        //when
        HelpfulGetResponseDTO helpfulGetResponseDTO1 = helpfulGetBean.exec(newUser1.getUserId(), newReview.getReviewId());
        HelpfulGetResponseDTO helpfulGetResponseDTO2 = helpfulGetBean.exec(newUser2.getUserId(), newReview.getReviewId());
        //then
        assertTrue(helpfulGetResponseDTO1.isHelpful());
        assertFalse(helpfulGetResponseDTO2.isHelpful());
    }

    @Autowired
    private HelpfulPostBean helpfulPostBean;

    @Test
    void HelpfulPostBeanTest() {
        UserDAO newUser1 = UserDAO.createTest(1);
        UserDAO newUser2 = UserDAO.createTest(2);
        userRepository.save(newUser1);
        userRepository.save(newUser2);

        GameDAO newGame = GameDAO.createTest(1, newUser1);
        gameRepository.save(newGame);

        //given
        ReviewDAO newReview = ReviewDAO.createTest(1, newGame, newUser1);
        reviewRepository.save(newReview);

        //when
        helpfulPostBean.exec(newUser1.getUserId(), newReview.getReviewId());
        helpfulPostBean.exec(newUser2.getUserId(), newReview.getReviewId());
        //then
        assertEquals(2, helpfulRepository.count());
    }

    @Autowired
    private HelpfulDeleteBean helpfulDeleteBean;

    @Test
    void HelpfulDeleteBeanTest() {
        //given
        UserDAO newUser1 = UserDAO.createTest(1);
        userRepository.save(newUser1);

        UserDAO newUser2 = UserDAO.createTest(2);
        userRepository.save(newUser2);

        GameDAO newGame = GameDAO.createTest(1, newUser1);
        gameRepository.save(newGame);

        ReviewDAO newReview = ReviewDAO.createTest(1, newGame, newUser1);
        reviewRepository.save(newReview);

        helpfulPostBean.exec(newUser1.getUserId(), newReview.getReviewId());
        helpfulPostBean.exec(newUser2.getUserId(), newReview.getReviewId());

        //2초 대기
        try {
            Thread.sleep(101);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //when
        helpfulDeleteBean.exec(newUser1.getUserId(), newReview.getReviewId());
        helpfulDeleteBean.exec(newUser2.getUserId(), newReview.getReviewId());
        //then
        assertEquals(0, helpfulRepository.count());
    }
}
