package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogCatchTopChange;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Request.LogPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogPostResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ScoreType;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class LogBeanTest {

    @Autowired
    private EntityManager em;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogCatchTopChange logCatchTopChange;

    @Test
    void LogCatchTopChangeTest() {
        UserDAO user1 = UserDAO.createTest(1);

        UserDAO user2 = UserDAO.createTest(2);

        userRepository.save(user1);
        userRepository.save(user2);

        GameDAO game1 = GameDAO.createTest(1, user1);
        game1.setScoreType(ScoreType.INFINITE);
        gameRepository.save(game1);


        for (int i = 1; i <= 50; i++) {
            LogDAO newLog = LogDAO.createTest(i, game1, user1);

            logRepository.save(newLog);

            Boolean isChange = logCatchTopChange.exec(game1);

            assertFalse(isChange);
        }

        for (int i = 51; i <= 100; i++) {
            LogDAO newLog = LogDAO.createTest(i, game1, user2);

            logRepository.save(newLog);

            Boolean isChange = logCatchTopChange.exec(game1);

            assertFalse(isChange);
        }

        LogDAO newLog = LogDAO.createTest(101, game1, user1);

        logRepository.save(newLog);

        Boolean isChange = logCatchTopChange.exec(game1);

        assertTrue(isChange);

    }

    @Autowired
    private LogGetByGameIdBean logGetByGameIdBean;

    @Test
    void LogGetByGameIdBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game1 = GameDAO.createTest(0, user);
        game1.setScoreType(ScoreType.INFINITE);
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(3, user);
        game2.setScoreType(ScoreType.GOAL);
        game2.setTargetScore(((double) 5));
        gameRepository.save(game2);

        for (int i = 0; i < 12; i++) {
            LogDAO log1 = LogDAO.createTest(i, game1, user);
            logRepository.save(log1);

            LogDAO log2 = LogDAO.createTest(i, game2, user);
            logRepository.save(log2);
        }

        List<LogDAO> game1List = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGame().getGameId().equals(game1.getGameId()))
                .sorted(Comparator.comparing(LogDAO::getGameScore).reversed().thenComparing(LogDAO::getLogId))
                .limit(10)
                .collect(Collectors.toList());

        Double targetScore = game2.getTargetScore();

        List<LogDAO> game2List = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGame().getGameId().equals(game2.getGameId()))
                .sorted((o1, o2) -> {
                    double g1 = targetScore - o1.getGameScore();
                    double g2 = targetScore - o2.getGameScore();
                    if (g1 == g2)
                        return Long.compare(o1.getLogId(), o2.getLogId());
                    return Double.compare(Math.abs(g1), Math.abs(g2));
                })
                .limit(10)
                .collect(Collectors.toList());

        //when
        List<LogGetByGameIdResponseDTO> exec1 = logGetByGameIdBean.exec(game1.getGameId(), 0, 10);
        List<LogGetByGameIdResponseDTO> exec2 = logGetByGameIdBean.exec(game2.getGameId(), 0, 10);
        //then

        assertEquals(game1List.size(), exec1.size());
        for (int i = 0; i < game1List.size(); i++) {
            assertEquals(game1List.get(i).getLogId(), exec1.get(i).getLogId());
        }

        assertEquals(game2List.size(), exec2.size());

        System.out.println(game2List);
        System.out.println(exec2);

        for (int i = 0; i < game2List.size(); i++) {
            LogDAO dao = game2List.get(i);
            LogGetByGameIdResponseDTO dao1 = exec2.get(i);
            System.out.println("====================================");
            System.out.println(dao);
            System.out.println(dao1);
            System.out.println("====================================");

            assertEquals(dao.getLogId(), dao1.getLogId());
        }
    }

    @Autowired
    private LogGetByGamIdUserIdBean logGetByGamIdUserIdBean;

    @Test
    void LogGetByGamIdUserIdBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game1 = GameDAO.createTest(0, user);
        game1.setScoreType(ScoreType.INFINITE);
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(3, user);
        game2.setScoreType(ScoreType.GOAL);
        game2.setTargetScore(((double) 5));
        gameRepository.save(game2);

        for (int i = 0; i < 12; i++) {
            LogDAO log1 = LogDAO.createTest(i, game1, user);
            logRepository.save(log1);

            LogDAO log2 = LogDAO.createTest(i, game2, user);
            logRepository.save(log2);
        }

        LogDAO expect1 = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGame().getGameId().equals(game1.getGameId()))
                .sorted(Comparator.comparing(LogDAO::getGameScore).reversed().thenComparing(LogDAO::getLogId))
                .limit(1).findAny().orElse(new LogDAO());

        Double targetScore = game2.getTargetScore();

        LogDAO expect2 = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGame().getGameId().equals(game2.getGameId()))
                .sorted((o1, o2) -> {
                    double g1 = targetScore - o1.getGameScore();
                    double g2 = targetScore - o2.getGameScore();
                    if (g1 == g2)
                        return Long.compare(o1.getLogId(), o2.getLogId());
                    return Double.compare(Math.abs(g1), Math.abs(g2));
                })
                .limit(1).findAny().orElse(new LogDAO());

        //when
        LogGetByGameIdUserIdResponseDTO exec1 = logGetByGamIdUserIdBean.exec(game1.getGameId(), user.getUserId());
        LogGetByGameIdUserIdResponseDTO exec2 = logGetByGamIdUserIdBean.exec(game2.getGameId(), user.getUserId());

        //then
        assertEquals(expect1.getLogId(), exec1.getLogId());
        assertEquals(expect2.getLogId(), exec2.getLogId());
    }

    @Autowired
    private LogPostBean logPostBean;

    @Test
    void LogPostBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game1 = GameDAO.createTest(0, user);
        game1.setScoreType(ScoreType.INFINITE);
        gameRepository.save(game1);


        LogDAO logDAO = LogDAO.createTest(0, game1, user);
        logRepository.save(logDAO);

        //when
        LogPostResponseDTO exec = logPostBean.exec(LogPostRequestDTO.of(logDAO));

        em.flush();

        UserDAO findUser = userRepository.findById(user.getUserId()).get();

        System.out.println("user.getLastPlayTime() = " + user.getLastPlayTime());
        System.out.println("findUser.getLastPlayTime() = " + findUser.getLastPlayTime());


        //then
        assertEquals(logDAO.getGame().getGameId(), exec.getGameId());

        // then LastPlayTime is updated
        assertNotEquals(user.getLastPlayTime(), findUser.getLastPlayTime());
    }

    @Test
    void GetRankTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game1 = GameDAO.createTest(0, user);
        game1.setScoreType(ScoreType.INFINITE);
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(3, user);
        game2.setScoreType(ScoreType.GOAL);
        game2.setTargetScore(((double) 5));
        gameRepository.save(game2);

        for (int i = 0; i < 12; i++) {
            LogDAO log1 = LogDAO.createTest(i, game1, user);
            logRepository.save(log1);

            LogDAO log2 = LogDAO.createTest(i, game2, user);
            logRepository.save(log2);
        }

        List<LogDAO> expect1 = logRepository.findAll().stream().filter(logDAO -> logDAO.getGame().getGameId() == game1.getGameId())
                .sorted(Comparator.comparing(LogDAO::getGameScore).reversed().thenComparing(LogDAO::getLogId))
                .collect(Collectors.toList());

        List<LogDAO> expect2 = logRepository.findAll().stream().filter(logDAO -> logDAO.getGame().getGameId() == game2.getGameId())
                .sorted((o1, o2) -> {
                    double g1 = game2.getTargetScore() - o1.getGameScore();
                    double g2 = game2.getTargetScore() - o2.getGameScore();
                    if (g1 == g2)
                        return Long.compare(o1.getLogId(), o2.getLogId());
                    return Double.compare(Math.abs(g1), Math.abs(g2));
                }).collect(Collectors.toList());


        LogDAO findDAO1 = logRepository.findFirstByGameAndUserOrderByGameScoreDesc(game1, user).get();
        LogDAO findDAO2 = logRepository.findByGameOrderByGameScoreWithTargetScore(game2, game2.getTargetScore(), PageRequest.of(0, 1)).stream().findAny().get();

        Long rank1 = logRepository.getRankInfinite(findDAO1.getGameScore(), findDAO1.getGame());
        Long rank2 = logRepository.getRankGoal(game2.getTargetScore(), findDAO2.getGameScore(), game2);

        long cnt1 = expect1.stream().filter(logDAO -> logDAO.getGameScore() >= findDAO1.getGameScore()).count();
        long cnt2 = expect2.stream().filter(logDAO -> Math.abs(game2.getTargetScore() - logDAO.getGameScore()) <= Math.abs(game2.getTargetScore() - findDAO2.getGameScore())).count();


        assertEquals(cnt1, rank1);
        assertEquals(cnt2, rank2);
    }
}