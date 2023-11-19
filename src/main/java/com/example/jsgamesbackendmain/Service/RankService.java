package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankGetBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankGetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RankService {

    @Autowired
    private RankGetBean rankGetBean;
    @Autowired
    private GameListBean gameListBean;
    @Autowired
    private MapperBean mapperBean;

    public RankGetResponseDTO rankGet(Long page, Long size) {
        return rankGetBean.exec(page, size);
    }

    public List<GameListResponseDTO> listGames(Long page, Long size) {
        return gameListBean.exec(page, size);
    }
}
