package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByCreateAtSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByLogCountDescSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByReviewCountSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameListOrderByViewCountSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.GameSort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetGames {
    private final GameListOrderByViewCountSmallBean gameListOrderByViewCountSmallBean;
    private final GameListOrderByLogCountDescSmallBean gameListOrderByLogCountDescSmallBean;
    private final GameListOrderByCreateAtSmallBean gameListOrderByCreateAtSmallBean;
    private final GameListOrderByReviewCountSmallBean gameListOrderByReviewCountSmallBean;

    public List<GameListResponseDTO> exec(Integer page, Integer size, GameSort sort) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<GameDAO> gamePageList = null;

        switch (sort) {
            case VIEW_COUNT:
                gamePageList = gameListOrderByViewCountSmallBean.exec(pageRequest);
                break;
            case LOG_COUNT:
                gamePageList = gameListOrderByLogCountDescSmallBean.exec(pageRequest);
                break;
            case RECENT:
                gamePageList = gameListOrderByCreateAtSmallBean.exec(pageRequest);
                break;
            case REVIEW_COUNT:
                gamePageList = gameListOrderByReviewCountSmallBean.exec(pageRequest);
                break;
        }

        return GameListResponseDTO.listOf(gamePageList);
    }
}
