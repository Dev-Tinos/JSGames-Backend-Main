package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GetGame;
import com.example.jsgamesbackendmain.Bean.GameBean.GetGamesByUser;
import com.example.jsgamesbackendmain.Bean.GameBean.GetGames;
import com.example.jsgamesbackendmain.Bean.GameBean.PostGame;
import com.example.jsgamesbackendmain.Model.DTO.Game.Request.GameCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameCreateResultDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.GameSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameService {
    private final PostGame gamePostBean;
    private final GetGames gameListBean;
    private final GetGame gameGetBean;
    private final GetGamesByUser gameGetListByPlayedUser;

    @Transactional
    public GameCreateResultDTO postGame(GameCreateRequestDTO gameCreateRequestDTO) {
        return gamePostBean.exec(gameCreateRequestDTO);
    }

    @Transactional
    public List<GameListResponseDTO> listGames(Integer page, Integer size, GameSort sort) {
        return gameListBean.exec(page, size, sort);
    }
    @Transactional
    public GameGetByGameIdResponseDTO getGame(Long gameId) {
        return gameGetBean.exec(gameId);
    }

    @Transactional
    public List<GameListResponseDTO> listGamesByUser(String userId, Integer page, Integer size) {
        return gameGetListByPlayedUser.exec(userId, page, size);
    }
}
