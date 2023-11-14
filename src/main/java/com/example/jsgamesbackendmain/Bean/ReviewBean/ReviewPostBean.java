package com.example.jsgamesbackendmain.Bean.ReviewBean;

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
//        ReviewDAO comment = ReviewCreateRequestDTO.toDAO(requestDTO);
//        ReviewDAO savedComment = reviewRepository.save(comment);
//
//        return ReviewDTO.of(savedComment);
        return null;
    }
}
