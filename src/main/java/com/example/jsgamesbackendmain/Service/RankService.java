package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.GameBean.GameListBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserGetTop100Bean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserSetTop100Bean;
import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.Game.Response.GameListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetTop100ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class RankService {

    @Autowired
    private UserGetTop100Bean userGetTop100Bean;
    @Autowired
    private GameListBean gameListBean;

    public List<UserGetTop100ResponseDTO> getTop100User(Long page, Long size) {
        List<UserTop100DAO> daoList = userGetTop100Bean.exec(page, size);
        return daoList.stream().map(UserGetTop100ResponseDTO::of).collect(Collectors.toList());
    }

    public List<GameListResponseDTO> listGames(Long page, Long size) { return gameListBean.exec(page, size); }
}
