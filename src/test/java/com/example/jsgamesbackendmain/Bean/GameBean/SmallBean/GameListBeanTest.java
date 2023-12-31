package com.example.jsgamesbackendmain.Bean.GameBean.SmallBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByCreateAtSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByLogCountDescSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByReviewCountSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByViewCountSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ActiveProfiles("test")
public class GameListBeanTest {
    private final GameListOrderByViewCountSmallBean gameListOrderByViewCountSmallBean;
    private final GameListOrderByLogCountDescSmallBean gameListOrderByLogCountDescSmallBean;
    private final GameListOrderByCreateAtSmallBean gameListOrderByCreateAtSmallBean;
    private final GameListOrderByReviewCountSmallBean gameListOrderByReviewCountSmallBean;
    private final UserRepository userRepository;
    private final GameRepository gameRepository;
    private final LogRepository logRepository;
    private final ReviewRepository reviewRepository;

    @Autowired
    public GameListBeanTest(
            GameListOrderByViewCountSmallBean gameListOrderByViewCountSmallBean,
            GameListOrderByLogCountDescSmallBean gameListOrderByLogCountDescSmallBean,
            GameListOrderByCreateAtSmallBean gameListOrderByCreateAtSmallBean,
            GameListOrderByReviewCountSmallBean gameListOrderByReviewCountSmallBean,
            UserRepository userRepository,
            GameRepository gameRepository,
            LogRepository logRepository,
            ReviewRepository reviewRepository
    ) {
        this.gameListOrderByViewCountSmallBean = gameListOrderByViewCountSmallBean;
        this.gameListOrderByLogCountDescSmallBean = gameListOrderByLogCountDescSmallBean;
        this.gameListOrderByCreateAtSmallBean = gameListOrderByCreateAtSmallBean;
        this.gameListOrderByReviewCountSmallBean = gameListOrderByReviewCountSmallBean;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.logRepository = logRepository;
        this.reviewRepository = reviewRepository;
    }

    @Test
    @Transactional
    void GameListOrderByViewCountSmallBeanTest() {
        //given
        UserDAO newUser = UserDAO.builder()
                .userId("1")
                .build();
        userRepository.save(newUser);

        ArrayList<GameDAO> gameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            GameDAO newGame = GameDAO.builder()
                    .user(newUser)
                    .viewCount(((long) i))
                    .build();

            gameRepository.save(newGame);
            gameList.add(newGame);
        }

        //when
        List<GameDAO> exec = gameListOrderByViewCountSmallBean.exec(PageRequest.of(0, 10)).toList();

        Comparator<GameDAO> comparator = Comparator.comparing(GameDAO::getViewCount).reversed();

        List<GameDAO> expect = gameList.stream()
                .sorted(comparator.thenComparing(GameDAO::getGameId))
                .collect(Collectors.toList());

        //then
        for (int i = 0; i < 10; i++) {
            assertEquals(expect.get(i).getGameId(), exec.get(i).getGameId());
        }
    }

    @Test
    @Transactional
     void GameListOrderByLogCountDescSmallBeanTest() {
        //given
        UserDAO newUser = UserDAO.builder()
                .userId("1")
                .build();
        userRepository.save(newUser);

        ArrayList<GameDAO> gameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            GameDAO newGame = GameDAO.builder()
                    .user(newUser)
                    .build();

            newGame.setUser(newUser);

            gameRepository.save(newGame);
            gameList.add(newGame);
        }

        for (int i = 0; i < gameList.size(); i++) {
            GameDAO findGame = gameList.get(i);
            for (int j = 0; j < i; j++) {
                LogDAO newLog = LogDAO.createTest(j, findGame, newUser);
                logRepository.save(newLog);
            }

        }

        //when
        List<GameDAO> exec = gameListOrderByLogCountDescSmallBean.exec(PageRequest.of(0, 10)).toList();

        Function<GameDAO, Integer> logCount = gameDAO -> gameDAO.getLogs().size();
        Comparator<GameDAO> comparator = Comparator.comparing(logCount).reversed();

        List<GameDAO> expect = gameList.stream()
                .sorted(comparator.thenComparing(GameDAO::getGameId))
                .collect(Collectors.toList());

        //then
        for (int i = 0; i < 10; i++) {
            assertEquals(expect.get(i).getGameId(), exec.get(i).getGameId());
        }
    }

    @Test
    @Transactional
    void GameListOrderByCreateAtSmallBeanTest() {
        //given
        UserDAO newUser = UserDAO.builder()
                .userId("1")
                .build();
        userRepository.save(newUser);

        ArrayList<GameDAO> gameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            GameDAO newGame = GameDAO.builder()
                    .user(newUser)
                    .build();

            newGame.setUser(newUser);

            gameRepository.save(newGame);
            gameList.add(newGame);
        }

        //when
        List<GameDAO> exec = gameListOrderByCreateAtSmallBean.exec(PageRequest.of(0, 10)).toList();

        Comparator<GameDAO> comparator = Comparator.comparing(GameDAO::getCreatedAt).reversed();

        List<GameDAO> expect = gameList.stream()
                .sorted(comparator.thenComparing(GameDAO::getGameId))
                .collect(Collectors.toList());

        //then
        for (int i = 0; i < 10; i++) {
            assertEquals(expect.get(i).getGameId(), exec.get(i).getGameId());
        }
    }

    @Test
    @Transactional
    void GameListOrderByReviewCountSmallBeanTest() {
        //given
        ArrayList<UserDAO> userList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            UserDAO newUser = UserDAO.builder()
                    .userId(i + "")
                    .build();
            userRepository.save(newUser);
            userList.add(newUser);
        }

        ArrayList<GameDAO> gameList = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            UserDAO findUser = userList.get(0);
            GameDAO newGame = GameDAO.builder()
                    .user(findUser)
                    .build();

            newGame.setUser(findUser);

            gameRepository.save(newGame);
            gameList.add(newGame);
        }

        for (int i = 0; i < gameList.size(); i++) {
            GameDAO findGame = gameList.get(i);
            for (int j = 0; j < i; j++) {
                ReviewDAO newReview = ReviewDAO.createTest(j, findGame, userList.get(j));
                reviewRepository.save(newReview);
            }
        }

        //when
        List<GameDAO> exec = gameListOrderByReviewCountSmallBean.exec(PageRequest.of(0, 10)).toList();

        Function<GameDAO, Integer> reviewSizeFunction = gameDAO -> gameDAO.getReviews().size();

        Comparator<GameDAO> compareReviewSizeReverse = Comparator.comparing(reviewSizeFunction).reversed();
        Comparator<GameDAO> compareGameId = Comparator.comparing(GameDAO::getGameId);

        List<GameDAO> expect = gameList.stream()
                .sorted(
                        compareReviewSizeReverse
                        .thenComparing(compareGameId)
                )
                .collect(Collectors.toList());

        //then
        for (int i = 0; i < 10; i++) {
            assertEquals(expect.get(i).getGameId(), exec.get(i).getGameId());
        }
    }
}
