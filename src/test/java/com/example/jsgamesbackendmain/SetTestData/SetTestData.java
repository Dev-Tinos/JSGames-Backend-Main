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

    @Test
    @Rollback(value = false)
    void Test_데이터_넣기() {
        // all delete
//        logRepository.deleteAll();
//        userRepository.deleteAll();
//        gameRepository.deleteAll();
//        reviewRepository.deleteAll();


        // Create 30 users
        for (int i = 0; i < 30; i++) {
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

        // Create 90 games
        for (int i = 0; i < 90; i++) {
            GameDAO gameDAO = new GameDAO();
            gameDAO.setGameName("name " + i);
            gameDAO.setUserId(userDAOList.get(i % userDAOList.size()).getUserId());
            gameDAO.setImageUrl("imageUrl " + i);
            gameDAO.setGameUrl("gameUrl " + i);
            ScoreType scoreType = scoreTypes[i % scoreTypes.length];
            gameDAO.setScoreType(scoreType);
            if (scoreType == ScoreType.GOAL) {
                gameDAO.setTargetScore((double) (i % 100));
            }else {
                gameDAO.setTargetScore((double) -1);
            }
            gameDAO.setDescription("description " + i);
            gameDAO.setViewCount(0L);

            gameDAOList.add(gameDAO);
            gameRepository.save(gameDAO);
        }

        // Create 360 reviews
        for (int j = 0; j < 360; j++) {
            ReviewDAO reviewDAO = new ReviewDAO();
            reviewDAO.setGameId(gameDAOList.get(j % gameDAOList.size()).getGameId());
            reviewDAO.setUserId(userDAOList.get(j % userDAOList.size()).getUserId());
            reviewDAO.setReviewContent("reviewContent " + j);
            reviewDAO.setStar((float) (j % 5) + 1);
            LocalDateTime now = LocalDateTime.now();
            reviewDAO.setDateTime(now.plusDays(1));
            reviewDAO.setHelpful((float) j);

            reviewDAOList.add(reviewDAO);
            reviewRepository.save(reviewDAO);
        }


        // Create 450 logs
        for (int i = 0; i < 450; i++) {
            LogDAO dao = new LogDAO();
            dao.setGameId(gameDAOList.get(i % gameDAOList.size()).getGameId());
            dao.setUserId(userDAOList.get(i % userDAOList.size()).getUserId());
            dao.setGameScore((double) (i % 100));

            logDAOList.add(dao);
            logRepository.save(dao);
        }
    }
}