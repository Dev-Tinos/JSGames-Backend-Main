package com.example.jsgamesbackendmain.Bean.SmallBean.ResultBean;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultGetByUserIdSmallBean {
    @Autowired
    private ResultRepository resultRepository;

    public List<ResultGetByUserIdResponseDTO> exec(Long userId, Long page, Long size) {
        Pageable pageable = PageRequest.of(page.intValue(), size.intValue());

        Page<ResultDAO> order = resultRepository.findByUserIdOrderByGameScoreDesc(userId, pageable);

        List<ResultDAO> results = order.toList();

        return results.stream().map(ResultGetByUserIdResponseDTO::of).collect(Collectors.toList());
    }
}
