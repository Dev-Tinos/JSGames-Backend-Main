package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.GameSort;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameListBean {
    private final GameRepository gameRepository;

    public List<GameListResponseDTO> exec(Integer page, Integer size, GameSort sort) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<GameDAO> gamePageList = null;

        switch (sort) {
            case VIEW_COUNT:
                gamePageList = gameRepository.findAllByOrderByViewCountDescGameIdAsc(pageRequest);
                break;
            case LOG_COUNT:
                gamePageList = gameRepository.findAllByOrderByLogCountDescGameIdAsc(pageRequest);
                break;
            case RECENT:
                gamePageList = gameRepository.findAllByOrderByCreatedAtDescGameIdAsc(pageRequest);
                break;
            case REVIEW_COUNT:
                gamePageList = gameRepository.findAllByOrderByReviewCountDescGameIdAsc(pageRequest);
                break;
        }

        return GameListResponseDTO.listOf(gamePageList);
    }
}
