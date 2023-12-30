package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class LogGetByUserIdSmallBean {
    private final LogRepository logRepository;

    public List<LogGetByUserIdResponseDTO> exec(UserDAO user, Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);

        return logRepository.findByUserOrderByGameScoreDesc(user, pageable)
                .stream()
                .map(logDAO -> LogGetByUserIdResponseDTO.of(logDAO, user))
                .collect(Collectors.toList());
    }
}
