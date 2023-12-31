package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameGetBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GameGetListByPlayedUser;
import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.GameBean.GamePostBean;
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
    private final GamePostBean gamePostBean;
    private final GameListBean gameListBean;
    private final GameGetBean gameGetBean;
    private final GameGetListByPlayedUser gameGetListByPlayedUser;

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
