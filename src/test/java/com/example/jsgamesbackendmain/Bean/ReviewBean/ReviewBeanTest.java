package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class ReviewBeanTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private ReviewListByGameBean reviewListByGameBean;

    @Test
    void ReviewListByGameBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        for (int i = 0; i < 2; i++) {
            GameDAO game = GameDAO.createTest(i);
            game.setUserId(user.getUserId());
            gameRepository.save(game);
        }
        GameDAO game = gameRepository.findAll().stream().findAny().orElse(new GameDAO());
        Long gameId = game.getGameId();

        List<ReviewDAO> list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            ReviewDAO review = ReviewDAO.createTest(i);
            review.setGameId(gameId);
            review.setUserId(user.getUserId());
            reviewRepository.save(review);
            list.add(review);
        }

        List<ReviewDAO> expect = list.stream()
                .filter(reviewDAO -> reviewDAO.getGameId() == gameId)
                .sorted(Comparator.comparing(ReviewDAO::getDateTime))
                .limit(10)
                .collect(Collectors.toList());

        //when
        List<ReviewGetByGameIdResponseDTO> exec = reviewListByGameBean.exec(gameId, 0L, 10L);

        //then
        assertEquals(expect.size(), exec.size());
        for(int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i).getReviewId(), exec.get(i).getReviewId());
        }
    }

    @Autowired
    private ReviewPostBean reviewPostBean;

    @Test
    void ReviewPostBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game = GameDAO.createTest(0);
        game.setUserId(user.getUserId());
        gameRepository.save(game);


        ReviewDAO review = ReviewDAO.createTest(0);
        review.setGameId(game.getGameId());
        review.setUserId(user.getUserId());
        ReviewCreateRequestDTO requestDTO = mapperBean.to(review, ReviewCreateRequestDTO.class);

        //when
        ReviewDTO exec = reviewPostBean.exec(requestDTO);

        //then
        ReviewDAO expect = reviewRepository.findAll().stream().findAny().orElse(new ReviewDAO());

        assertEquals(expect.getReviewId(), exec.getReviewId());
    }

    @Autowired
    private ReviewUpdateBean reviewUpdateBean;
    @Test
    void ReviewUpdateBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game = GameDAO.createTest(0);
        game.setUserId(user.getUserId());
        gameRepository.save(game);

        ReviewDAO review = ReviewDAO.createTest(0);
        review.setGameId(game.getGameId());
        review.setUserId(user.getUserId());
        reviewRepository.save(review);

        ReviewUpdateRequestDTO requestDTO = new ReviewUpdateRequestDTO();
        requestDTO.setReviewContent("update");
        //when
        ReviewUpdateResponseDTO exec = reviewUpdateBean.exec(review.getReviewId(), requestDTO);

        //then
        ReviewDAO expect = reviewRepository.findById(exec.getReviewId()).orElse(new ReviewDAO());
        assertEquals(expect.getReviewContent(), exec.getReviewContent());
    }
}