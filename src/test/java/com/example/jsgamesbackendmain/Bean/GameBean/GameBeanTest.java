package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetListByPlayedUserSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameCreateResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.GameSort;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import com.example.jsgamesbackendmain.Repository.LogRepository;
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
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
@ActiveProfiles("test")
class GameBeanTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private GameGetListByPlayedUserSmallBean gameGetListByPlayedUserSmallBean;

    @Test
    void GameGetListByPlayedUserSmallBeanTest() {
        //given
        UserDAO user1 = UserDAO.createTest(0);
        userRepository.save(user1);

        UserDAO user2 = UserDAO.createTest(0);
        user2.setUserId("2");
        userRepository.save(user2);

        ArrayList<UserDAO> userList = new ArrayList<>();

        userList.add(user1);
        userList.add(user2);

        GameDAO game1 = GameDAO.createTest(0, user1);
        gameRepository.save(game1);

        GameDAO game2 = GameDAO.createTest(0, user2);
        gameRepository.save(game2);

        ArrayList<GameDAO> gameList = new ArrayList<>();

        gameList.add(game1);
        gameList.add(game2);

        for (int i = 0; i < 4; i++) {
            logRepository.save(LogDAO.createTest(0, game1, user1));
        }

        for (int i = 0; i < 6; i++) {
            logRepository.save(LogDAO.createTest(0, game2, user2));
        }

        List<LogDAO> logList = logRepository.findAll();

        //when
        PageRequest request = PageRequest.of(0, 10);

        List<GameDAO> actual = gameGetListByPlayedUserSmallBean.exec(user1, request);

        // Create Comparator
        Comparator<LogDAO> createAtDesc = Comparator.comparing(LogDAO::getCreatedAt).reversed();

        // Create Grouping By gameId
        Map<Long, List<LogDAO>> collect = logList.stream()
                .filter(logDAO -> logDAO.getUser().getUserId().equals(user1.getUserId()))
                .collect(Collectors.groupingBy(logDAO -> logDAO.getGame().getGameId()));


        // Find Max CreatedAt Logs and Get Games
        List<GameDAO> expect = collect.keySet().stream()
                .map(key -> collect.get(key).stream().max(createAtDesc).get().getGame())
                .sorted(Comparator.comparing(GameDAO::getGameId))
                .collect(Collectors.toList());

        //then
        for (int i = 0; i < expect.size(); i++) {
            assertEquals(expect.get(i).getGameId(), actual.get(i).getGameId());
        }

    }


    @Autowired
    private GameGetBean gameGetBean;

    @Test
    void GameGetBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);
        GameDAO game = GameDAO.createTest(0, user);
        gameRepository.save(game);

        //when
        GameGetByGameIdResponseDTO exec = gameGetBean.exec(game.getGameId());
        //then
        assertEquals(game.getGameId(), exec.getGameId());
    }

    @Autowired
    private GameListBean gameListBean;

    @Test
    void GameListBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);
        for (int i = 0; i < 12; i++) {
            GameDAO game = GameDAO.createTest(i, user);
            gameRepository.save(game);
        }

        List<GameDAO> gameList = gameRepository.findAll().stream()
                .sorted(Comparator.comparing(GameDAO::getViewCount).reversed())
                .limit(10)
                .collect(Collectors.toList());
        //when
        List<GameListResponseDTO> exec = gameListBean.exec(0, 10, GameSort.VIEW_COUNT);

        //then
        assertEquals(gameList.size(), exec.size());
        for (int i = 0; i < gameList.size(); i++) {
            assertEquals(gameList.get(i).getGameId(), exec.get(i).getGameId());
        }
    }

    @Autowired
    private GamePostBean gamePostBean;

    @Test
    void GamePostBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);

        GameDAO dao = GameDAO.createTest(0, user);

        //when
        GameCreateResultDTO exec = gamePostBean.exec(GameCreateRequestDTO.of(dao));

        //then
        List<GameDAO> all = gameRepository.findAll();
        assertEquals(1, all.size());
        assertEquals(exec.getGameId(), all.stream().findAny().orElse(null).getGameId());
    }
}