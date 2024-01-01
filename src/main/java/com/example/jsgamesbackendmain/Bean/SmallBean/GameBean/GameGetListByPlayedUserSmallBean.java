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
        List<Long> gameIds = gameRepository.findAllByPlayedUserOrderByCreatedAtDescGameIdAsc(user, pageRequest).toList();
        List<GameDAO> nonSorted = gameRepository.findByGameIdIn(gameIds);

        return nonSorted.stream()
                .sorted((o1, o2) -> {
                    int o1Index = gameIds.indexOf(o1.getGameId());
                    int o2Index = gameIds.indexOf(o2.getGameId());
                    return Integer.compare(o1Index, o2Index);
                }).collect(Collectors.toList());
    }
}
