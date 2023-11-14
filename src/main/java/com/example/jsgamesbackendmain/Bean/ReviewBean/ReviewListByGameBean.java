package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewListByGameBean {

    @Autowired
    private ReviewRepository reviewRepository;

    ObjectMapper objectMapper = new ObjectMapper();


    public List<ReviewGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        Page<ReviewDAO> all = reviewRepository.findByGameIdOrderByDateTimeAsc(gameId, pageRequest);

        return all.toList().stream().map(dao -> objectMapper.convertValue(dao , ReviewGetByGameIdResponseDTO.class)).collect(Collectors.toList());
    }
}
