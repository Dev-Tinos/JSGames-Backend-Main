package com.example.jsgamesbackendmain.Bean.LogBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.LogBean.LogGetByGameSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByGameIdResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetLogsByGameId {
    private final LogGetByGameSmallBean logGetByGameSmallBean;

    private final GameGetSmallBean gameGetSmallBean;

    public List<LogGetByGameIdResponseDTO> exec(Long gameId, Integer page, Integer size) {

        GameDAO gameDAO = gameGetSmallBean.exec(gameId);

        return logGetByGameSmallBean.exec(gameDAO, page, size).stream()
                .map(LogGetByGameIdResponseDTO::of)
                .collect(Collectors.toList());
    }

}
