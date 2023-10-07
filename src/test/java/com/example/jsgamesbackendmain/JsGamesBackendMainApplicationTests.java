package com.example.jsgamesbackendmain;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
class JsGamesBackendMainApplicationTests {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ResultRepository resultRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Test
    @Rollback(value = false)
    void contextLoads() {


//        GameDAO dao1 = new GameDAO();
//        dao1.setDescription("총알 피하기 게임입니다.");
//        dao1.setGameName("총알 피하기");
//        dao1.setGameUrl("https://jsgames-backend-main.herokuapp.com/game/dodge");
//        dao1.setImageUrl("https://jsgames-backend-main.herokuapp.com/game/dodge/img");
//        dao1.setScoreType(ScoreType.INFINITE);
//        dao1.setUserId(1L);
//
//        GameDAO dao2 = new GameDAO();
//        dao2.setDescription("적을 처치하는 게임입니다.");
//        dao2.setGameName("Kill the Enemy");
//        dao2.setGameUrl("https://jsgames-backend-main.herokuapp.com/game/kill");
//        dao2.setImageUrl("https://jsgames-backend-main.herokuapp.com/game/kill/img");
//        dao2.setScoreType(ScoreType.INFINITE);
//        dao2.setUserId(2L);
//
//        GameDAO dao3 = new GameDAO();
//        dao3.setDescription("반응속도 테스트 게임입니다.");
//        dao3.setGameName("반응속도!");
//        dao3.setGameUrl("https://jsgames-backend-main.herokuapp.com/game/reaction");
//        dao3.setImageUrl("https://jsgames-backend-main.herokuapp.com/game/reaction/img");
//        dao3.setScoreType(ScoreType.GOAL);
//        dao3.setTargetScore(0.0);
//        dao3.setUserId(3L);
//
//        gameRepository.save(dao1);
//        gameRepository.save(dao2);
//        gameRepository.save(dao3);
//
//        UserDAO userdao1 = new UserDAO();
//        userdao1.setNickname("동현쿤");
//        userdao1.setEmail("one@tukorea.ac.kr");
//        userdao1.setPassword("1234");
//        userdao1.setMajor("컴퓨터공학과");
//
//
//        UserDAO userdao2 = new UserDAO();
//        userdao2.setNickname("짜파게티");
//        userdao2.setEmail("two@tukorea.ac.kr");
//        userdao2.setPassword("1234");
//        userdao2.setMajor("소프트웨어공학과");
//
//        UserDAO userdao3 = new UserDAO();
//        userdao3.setNickname("피자");
//        userdao3.setEmail("three@tukorea.ac.kr");
//        userdao3.setPassword("1234");
//        userdao3.setMajor("전자공학과");
//
//        userRepository.save(userdao1);
//        userRepository.save(userdao2);
//        userRepository.save(userdao3);
//
//        for (int j = 1; j <= 3; j++) {
//            for (int k = 1; k <= 3; k++) {
//                for (int i = 1; i <= 5; i++) {
//                    ResultDAO dao = new ResultDAO();
//                    dao.setGameScore((double)i * k + j);
//                    dao.setUserId((long) k);
//                    dao.setGameId((long) j);
//                    resultRepository.save(dao);
//                }
//            }
//        }
//
//        for (int j = 1; j <= 3; j++) {
//            for (int k = 1; k <= 3; k++) {
//                for (int i = 1; i <= 5; i++) {
//                    CommentDAO dao = new CommentDAO();
//                    dao.setGameId((long) j);
//                    dao.setUserId((long) k);
//                    dao.setCommentContent("댓글" + i + j + k);
//                    commentRepository.save(dao);
//
//                }
//            }
//        }
    }
}
