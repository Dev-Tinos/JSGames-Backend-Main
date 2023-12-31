package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class GameGetSmallBean {

    private final GameRepository gameRepository;

    public GameDAO exec(Long gameId) {
        Optional<GameDAO> optional = gameRepository.findById(gameId);

        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Game not found for this id :: " + gameId);
        }
        return optional.get();
    }
}
