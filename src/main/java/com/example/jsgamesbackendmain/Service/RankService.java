package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RankService {

    private final RankGetBean rankGetBean;
    private final GameListBean gameListBean;

    public RankGetResponseDTO rankGet(Long page, Long size) {
        return rankGetBean.exec(page, size);
    }

    public List<GameListResponseDTO> listGames(Long page, Long size) {
        return gameListBean.exec(page, size);
    }
}
