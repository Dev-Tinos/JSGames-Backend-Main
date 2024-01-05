package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GameGetListByPlayedUserSmallBean {
    private final GameRepository gameRepository;
    public List<GameDAO> exec(UserDAO user, PageRequest pageRequest) {
        return gameRepository.findAllByPlayedUserOrderByCreatedAtDescGameIdAsc(user, pageRequest).toList();
    }
}
