package com.example.jsgamesbackendmain.Bean.SmallBean.GameBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GameListOrderByCreateAtSmallBean {
    private final GameRepository gameRepository;
    public Page<GameDAO> exec(Pageable pageable) {
return gameRepository.findAllByOrderByCreatedAtDescGameIdAsc(pageable);
    }
}
