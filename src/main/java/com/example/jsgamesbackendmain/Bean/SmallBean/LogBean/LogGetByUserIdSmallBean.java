package com.example.jsgamesbackendmain.Bean.SmallBean.LogBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Log.Response.LogGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.example.jsgamesbackendmain.Repository.LogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Autowired
    private MapperBean mapperBean;


    public List<LogGetByUserIdResponseDTO> exec(UserDAO user, Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue());

        Page<LogDAO> order = logRepository.findByUserIdOrderByGameScoreDesc(user.getUserId(), pageable);

        UserLogResponseDTO userResponseDTO = mapperBean.to(user, UserLogResponseDTO.class);

        return order.stream().map(l -> {
            LogGetByUserIdResponseDTO dto = mapperBean.to(l, LogGetByUserIdResponseDTO.class);
            dto.setUser(userResponseDTO);
            return dto;
        }).collect(Collectors.toList());
    }
}
