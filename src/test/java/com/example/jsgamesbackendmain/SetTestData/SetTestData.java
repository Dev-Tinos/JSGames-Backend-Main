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
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private LogRepository logRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private MajorMapperBean parentMajors;

    private List<UserDAO> userDAOList = new ArrayList<>();

    private List<GameDAO> gameDAOList = new ArrayList<>();

    private List<ReviewDAO> reviewDAOList = new ArrayList<>();

    private List<LogDAO> logDAOList = new ArrayList<>();

    private Major[] majors = Major.values();

    private ScoreType[] scoreTypes = ScoreType.values();
    private ObjectMapper objectMapper = new ObjectMapper();


//    @Test
//    @Rollback(value = false)
    void Test_데이터_넣기() {
        // all delete
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
            GameDAO gameDAO = new GameDAO();
            gameDAO.setGameName("name " + i);
            gameDAO.setUserId(userDAOList.get((int)(Math.random() * userSize)).getUserId());
            gameDAO.setImageUrl("imageUrl " + i);
            gameDAO.setGameUrl("gameUrl " + i);
            gameDAO.setViewCount(((long) i));
            ScoreType scoreType = scoreTypes[i % scoreTypes.length];
            gameDAO.setScoreType(scoreType);
            if (scoreType == ScoreType.GOAL) {
                gameDAO.setTargetScore((double) (int)(Math.random() * 100));
            }else {
                gameDAO.setTargetScore((double) -1);
            }
            gameDAO.setDescription("description " + i);
            gameDAO.setViewCount(((long) i));

            gameDAOList.add(gameDAO);
            gameRepository.save(gameDAO);
        }

        for (int j = 0; j < reviewSize; j++) {
            ReviewDAO reviewDAO = new ReviewDAO();
            reviewDAO.setGameId(gameDAOList.get((int)(Math.random() * gameSize)).getGameId());
            reviewDAO.setUserId(userDAOList.get((int)(Math.random() * gameSize)).getUserId());
            reviewDAO.setReviewContent("reviewContent " + j);
            reviewDAO.setStar((float) (j % 5) + 1);
            LocalDateTime now = LocalDateTime.now();
            reviewDAO.setDateTime(now.minusDays(j));
            reviewDAO.setHelpful((long) j);

            reviewDAOList.add(reviewDAO);
            reviewRepository.save(reviewDAO);
        }


        // Create 450 logs
        for (int i = 0; i < logSize; i++) {
            LogDAO dao = new LogDAO();
            dao.setGameId(gameDAOList.get((int)(Math.random() * gameSize)).getGameId());
            dao.setUserId(userDAOList.get((int)(Math.random() * userSize)).getUserId());
            dao.setGameScore((double) ((int)(Math.random() * 100)));

            logRepository.save(dao);
        }
    }
}