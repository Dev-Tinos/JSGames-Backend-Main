package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetListByPlayedUserSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameGetListByPlayedUser {

    @Autowired
    private GameGetListByPlayedUserSmallBean gameGetListByPlayedUserSmallBean;

    public List<GameListResponseDTO> exec(String userId, Long page, Long size) {
        PageRequest request = PageRequest.of(page.intValue(), size.intValue());

        return gameGetListByPlayedUserSmallBean.exec(userId, request);
    }
}
