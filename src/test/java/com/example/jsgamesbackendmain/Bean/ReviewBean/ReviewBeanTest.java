package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
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
    private GetReviewByGameIdAndUserId reviewGetMyReviewBean;

    @Test
    void ReviewGetMyReviewBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game = GameDAO.createTest(0, user);
        gameRepository.save(game);

        ReviewDAO review = ReviewDAO.createTest(0, game, user);
        reviewRepository.save(review);

        //when
        ReviewGetByGameIdResponseDTO exec = reviewGetMyReviewBean.exec(game.getGameId(), user.getUserId());

        //then
        assertEquals(review.getReviewId(), exec.getReviewId());
    }


    @Autowired
    private GetReviewsByGameId reviewListByGameBean;

    @Test
    void ReviewListByGameBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        for (int i = 0; i < 2; i++) {
            GameDAO game = GameDAO.createTest(i, user);
            gameRepository.save(game);
        }
        GameDAO game = gameRepository.findAll().stream().findAny().orElse(new GameDAO());
        Long gameId = game.getGameId();

        List<ReviewDAO> list = new ArrayList<>();

        for (int i = 0; i < 12; i++) {
            ReviewDAO review = ReviewDAO.createTest(i, game, user);
            reviewRepository.save(review);
            list.add(review);
        }

        Comparator<ReviewDAO> reversed = Comparator.comparing(ReviewDAO::getReviewId).reversed();

        List<ReviewDAO> recent = list.stream()
                .filter(reviewDAO -> reviewDAO.getGame().getGameId() == gameId)
                .sorted(
                        Comparator.comparing(ReviewDAO::getDateTime).reversed()
                        .thenComparing(reversed)
                )
                .limit(10)
                .collect(Collectors.toList());

        //when
        List<ReviewGetByGameIdResponseDTO> exec = reviewListByGameBean.exec(gameId, 0, 10, ReviewSort.RECENT);

        System.out.println("recent = " + recent);
        System.out.println("exec = " + exec);

        //then
        assertEquals(recent.size(), exec.size());
        for (int i = 0; i < recent.size(); i++) {

            System.out.println("e = " + exec.get(i).getReviewId());
            System.out.println("r = " + recent.get(i).getReviewId());

            assertEquals(recent.get(i).getReviewId(), exec.get(i).getReviewId());
        }



        List<ReviewDAO> oldest = list.stream()
                .filter(reviewDAO -> reviewDAO.getGame().getGameId() == gameId)
                .sorted(Comparator.comparing(ReviewDAO::getDateTime)
                        .thenComparing(reversed)
                )
                .limit(10)
                .collect(Collectors.toList());

        exec = reviewListByGameBean.exec(gameId, 0, 10, ReviewSort.OLDEST);

        assertEquals(oldest.size(), exec.size());
        for (int i = 0; i < oldest.size(); i++) {
            assertEquals(oldest.get(i).getReviewId(), exec.get(i).getReviewId());
        }

        List<ReviewDAO> star = list.stream()
                .filter(reviewDAO -> reviewDAO.getGame().getGameId() == gameId)
                .sorted(Comparator.comparing(ReviewDAO::getStar)
                        .thenComparing(ReviewDAO::getDateTime).reversed()
                ).limit(10).collect(Collectors.toList());

        exec = reviewListByGameBean.exec(gameId, 0, 10, ReviewSort.STAR);

        assertEquals(star.size(), exec.size());
        for (int i = 0; i < star.size(); i++) {
            assertEquals(star.get(i).getReviewId(), exec.get(i).getReviewId());
        }

        List<ReviewDAO> helpful = list.stream()
                .filter(reviewDAO -> reviewDAO.getGame().getGameId() == gameId)
                .sorted(Comparator.comparing(ReviewDAO::getHelpful)
                        .thenComparing(ReviewDAO::getDateTime).reversed()
                ).limit(10).collect(Collectors.toList());

        exec = reviewListByGameBean.exec(gameId, 0, 10, ReviewSort.HELPFUL);

        assertEquals(helpful.size(), exec.size());
        for (int i = 0; i < helpful.size(); i++) {
            assertEquals(helpful.get(i).getReviewId(), exec.get(i).getReviewId());
        }

    }

    @Autowired
    private PostReview reviewPostBean;

    @Test
    void ReviewPostBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        user.setUserId("1");
        userRepository.save(user);

        GameDAO game = GameDAO.createTest(0, user);
        gameRepository.save(game);


        ReviewCreateRequestDTO request = ReviewCreateRequestDTO.builder()
                .userId(user.getUserId())
                .gameId(game.getGameId())
                .reviewContent("test")
                .star(5f)
                .build();

        //when
        ReviewCreateResponseDTO exec = reviewPostBean.exec(request);

        //then
        ReviewDAO expect = reviewRepository.findAll().stream().findAny().orElse(new ReviewDAO());

        assertEquals(expect.getReviewId(), exec.getReviewId());
    }

    @Autowired
    private UpdateReview reviewUpdateBean;

    @Test
    void ReviewUpdateBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game = GameDAO.createTest(0, user);
        gameRepository.save(game);

        ReviewDAO review = ReviewDAO.createTest(0, game, user);

        reviewRepository.save(review);

        ReviewUpdateRequestDTO requestDTO = ReviewUpdateRequestDTO.builder()
                .reviewContent("update")
                .build();

        //when
        ReviewUpdateResponseDTO exec = reviewUpdateBean.exec(review.getReviewId(), requestDTO);

        //then
        ReviewDAO expect = reviewRepository.findById(exec.getReviewId()).orElse(new ReviewDAO());
        assertEquals(expect.getReviewContent(), exec.getReviewContent());
    }
}