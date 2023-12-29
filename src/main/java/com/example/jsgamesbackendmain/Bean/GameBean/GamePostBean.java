package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.GameDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GamePostBean {
    private final GameRepository gameRepository;
    private final UserGetByIdSmallBean userGetByIdSmallBean;
    public GameDTO exec(GameCreateRequestDTO gameCreateRequestDTO) {
        UserDAO findUser = userGetByIdSmallBean.exec(gameCreateRequestDTO.getUserId());

        GameDAO newGame = gameCreateRequestDTO.toDAO();

        newGame.setUser(findUser);

        return GameDTO.of(gameRepository.save(newGame));
    }
}
