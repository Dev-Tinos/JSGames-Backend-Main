package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
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
class GameBeanTest {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameRepository gameRepository;
    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private GameGetBean gameGetBean;
    @Test
    void GameGetBeanTest() {
        //given
        UserDAO user = UserDAO.createTest(0);
        userRepository.save(user);
        GameDAO game = GameDAO.createTest(0);
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
            GameDAO game = GameDAO.createTest(i);
            game.setUserId(user.getUserId());
            gameRepository.save(game);
        }

        List<GameDAO> gameList = gameRepository.findAll().stream()
                .sorted(Comparator.comparing(GameDAO::getViewCount).reversed())
                .limit(10)
                .collect(Collectors.toList());
        //when
        List<GameListResponseDTO> exec = gameListBean.exec(0L,10L);

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

        GameDAO dao = GameDAO.createTest(0);
        dao.setUserId(user.getUserId());
        dao.setGameId(null);

        GameCreateRequestDTO dto = mapperBean.to(dao, GameCreateRequestDTO.class);

        //when
        GameDTO exec = gamePostBean.exec(dto);

        //then
        List<GameDAO> all = gameRepository.findAll();
        assertEquals(1, all.size());
        assertEquals(exec.getGameId(), all.stream().findAny().orElse(null).getGameId());
    }
}