package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class LogBeanTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LogRepository logRepository;
    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private LogGetByGameIdBean logGetByGameIdBean;

    @Test
    void LogGetByGameIdBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO game1 = GameDAO.createTest(0);
        game1.setScoreType(ScoreType.INFINITE);
        game1.setUserId(user.getUserId());
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(3);
        game2.setUserId(user.getUserId());
        game2.setScoreType(ScoreType.GOAL);
        game2.setTargetScore(((double) 5));
        gameRepository.save(game2);

        for (int i = 0; i < 12; i++) {
            LogDAO log1 = LogDAO.createTest(i);
            log1.setGameId(game1.getGameId());
            log1.setUserId(user.getUserId());
            logRepository.save(log1);

            LogDAO log2 = LogDAO.createTest(i);
            log2.setGameId(game2.getGameId());
            log2.setUserId(user.getUserId());
            logRepository.save(log2);
        }

        List<LogDAO> game1List = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGameId().equals(game1.getGameId()))
                .sorted(Comparator.comparing(LogDAO::getGameScore).reversed().thenComparing(LogDAO::getLogId))
                .limit(10)
                .collect(Collectors.toList());

        Double targetScore = game2.getTargetScore();

        List<LogDAO> game2List = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGameId().equals(game2.getGameId()))
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

        GameDAO game1 = GameDAO.createTest(0);
        game1.setScoreType(ScoreType.INFINITE);
        game1.setUserId(user.getUserId());
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(3);
        game2.setUserId(user.getUserId());
        game2.setScoreType(ScoreType.GOAL);
        game2.setTargetScore(((double) 5));
        gameRepository.save(game2);

        for (int i = 0; i < 12; i++) {
            LogDAO log1 = LogDAO.createTest(i);
            log1.setGameId(game1.getGameId());
            log1.setUserId(user.getUserId());
            logRepository.save(log1);

            LogDAO log2 = LogDAO.createTest(i);
            log2.setGameId(game2.getGameId());
            log2.setUserId(user.getUserId());
            logRepository.save(log2);
        }

        LogDAO expect1 = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGameId().equals(game1.getGameId()))
                .sorted(Comparator.comparing(LogDAO::getGameScore).reversed().thenComparing(LogDAO::getLogId))
                .limit(1).findAny().orElse(new LogDAO());

        Double targetScore = game2.getTargetScore();

        LogDAO expect2 = logRepository.findAll().stream()
                .filter(logDAO -> logDAO.getGameId().equals(game2.getGameId()))
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

        GameDAO game1 = GameDAO.createTest(0);
        game1.setScoreType(ScoreType.INFINITE);
        game1.setUserId(user.getUserId());
        gameRepository.save(game1);


        LogDAO logDAO = LogDAO.createTest(0);
        logDAO.setUserId(user.getUserId());
        logDAO.setGameId(game1.getGameId());
        logRepository.save(logDAO);

        LogPostRequestDTO requestDTO = mapperBean.to(logDAO, LogPostRequestDTO.class);
        //when
        LogPostResponseDTO exec = logPostBean.exec(requestDTO);

        //then
        assertEquals(logDAO.getGameId(), exec.getGameId());
    }
}