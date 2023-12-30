package com.example.jsgamesbackendmain.Bean.GameBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetListByPlayedUserSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GameGetListByPlayedUser {

    private final GameGetListByPlayedUserSmallBean gameGetListByPlayedUserSmallBean;
    private final UserGetByIdSmallBean userGetByIdSmallBean;

    public List<GameListResponseDTO> exec(String userId, Integer page, Integer size) {
        PageRequest request = PageRequest.of(page, size);

        UserDAO findUser = userGetByIdSmallBean.exec(userId);

        return gameGetListByPlayedUserSmallBean.exec(findUser, request);
    }
}
