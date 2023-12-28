package com.example.jsgamesbackendmain.SetTestData;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
public class SetTestData {

    private final LogRepository logRepository;

    private final UserRepository userRepository;

    private final GameRepository gameRepository;

    private final ReviewRepository reviewRepository;

    private final MajorMapperBean parentMajors;

    @Autowired
    public SetTestData(
            LogRepository logRepository,
            UserRepository userRepository,
            GameRepository gameRepository,
            ReviewRepository reviewRepository,
            MajorMapperBean parentMajors
    ) {
        this.logRepository = logRepository;
        this.userRepository = userRepository;
        this.gameRepository = gameRepository;
        this.reviewRepository = reviewRepository;
        this.parentMajors = parentMajors;
    }

    private List<UserDAO> userDAOList = new ArrayList<>();

    private List<GameDAO> gameDAOList = new ArrayList<>();

    private List<ReviewDAO> reviewDAOList = new ArrayList<>();

    private List<LogDAO> logDAOList = new ArrayList<>();

    private Major[] majors = Major.values();

    private ScoreType[] scoreTypes = ScoreType.values();

    @Test
    void Test2() {
        GameDAO dao = new GameDAO();
        System.out.println("dao.getGameImage() = " + dao.getGameImage());

    }

    @Test
    @Rollback(value = true)
    void Test_데이터_넣기() {
//         all delete
//        logRepository.deleteAll();
//        userRepository.deleteAll();
//        gameRepository.deleteAll();
//        reviewRepository.deleteAll();

        int userSize = 50;
        int gameSize = 50;
        int reviewSize = 200;
        int logSize = 2000;


        for (int i = 0; i < userSize; i++) {
            UserDAO dao = new UserDAO();
            dao.setUserId(String.valueOf(i));
            dao.setEmail("test" + i + "@test.com");
            dao.setNickname("nick " + i);
            dao.setPassword("password " + i);
            // 각 과에 맞는 학부로 세팅되게 변경
            Major major = majors[i % majors.length];
            dao.setMajor(major);
            dao.setParentMajor(parentMajors.getParentMajor(major));
            userDAOList.add(dao);
            userRepository.save(dao);

        }

        for (int i = 0; i < gameSize; i++) {
            ScoreType scoreType = scoreTypes[i % scoreTypes.length];

            GameDAO gameDAO = GameDAO.builder()
                    .userId(userDAOList.get((int) (Math.random() * userSize)).getUserId())
                    .gameName(String.valueOf(i))
                    .gameUrl(String.valueOf(i))
                    .scoreType(scoreType)
                    .targetScore(scoreType == ScoreType.GOAL ?
                            (double) (int) (Math.random() * 100) :
                            (double) -1
                    )
                    .description(String.valueOf(i))
                    .viewCount(((long) i))
                    .build();

            gameDAOList.add(gameDAO);
            gameRepository.save(gameDAO);
        }

        for (int j = 0; j < reviewSize; j++) {
            ReviewDAO reviewDAO = ReviewDAO.builder()
                    .userId(userDAOList.get((int) (Math.random() * userSize)).getUserId())
                    .gameId(gameDAOList.get((int) (Math.random() * gameSize)).getGameId())
                    .reviewContent("reviewContent " + j)
                    .star((float) (j % 5) + 1)
                    .dateTime(LocalDateTime.now().minusDays(j))
                    .helpful((long) j)
                    .build();

            reviewDAOList.add(reviewDAO);
            reviewRepository.save(reviewDAO);
        }


        // Create 450 logs
        for (int i = 0; i < logSize; i++) {
            LogDAO newLog = LogDAO.builder()
                    .gameScore((double) ((int) (Math.random() * 100)))
                    .build();

            newLog.setGameId(gameDAOList.get((int) (Math.random() * gameSize)).getGameId());
            newLog.setUserId(userDAOList.get((int) (Math.random() * userSize)).getUserId());

            logRepository.save(newLog);
        }
    }
}