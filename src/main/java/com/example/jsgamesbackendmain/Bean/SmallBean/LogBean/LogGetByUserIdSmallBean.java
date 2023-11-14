package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class LogGetByUserIdSmallBean {
    @Autowired
    private LogRepository logRepository;

    public List<LogGetByUserIdResponseDTO> exec(Long userId, Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue());

        Page<LogDAO> order = logRepository.findByUserIdOrderByGameScoreDesc(userId, pageable);

        List<LogDAO> logs = order.toList();

        return logs.stream().map(LogGetByUserIdResponseDTO::of).collect(Collectors.toList());
    }
}
