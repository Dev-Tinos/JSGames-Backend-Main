package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewPostBean {

    @Autowired
    private ReviewRepository reviewRepository;

    ObjectMapper objectMapper = new ObjectMapper();

    public ReviewDTO exec(ReviewCreateRequestDTO requestDTO) {
        ReviewDAO dao = objectMapper.convertValue(requestDTO, ReviewDAO.class);

        ReviewDAO savedDao = reviewRepository.save(dao);

        return objectMapper.convertValue(savedDao, ReviewDTO.class);
    }
}
