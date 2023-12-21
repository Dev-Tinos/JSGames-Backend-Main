package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewGetAvgStarByGameIdSmallBean {
    @Autowired
    private ReviewRepository reviewRepository;

    public Double exec(Long gameId) {
        Optional<Double> optional = reviewRepository.findAvgStarByGameId(gameId);

        return optional.orElse(0.0);
    }
}
