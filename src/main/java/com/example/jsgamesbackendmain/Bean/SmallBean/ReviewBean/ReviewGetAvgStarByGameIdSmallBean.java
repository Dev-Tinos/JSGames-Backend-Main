package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewGetAvgStarByGameIdSmallBean {
    private final ReviewRepository reviewRepository;

    public Double exec(Long gameId) {
        Optional<Double> optional = reviewRepository.findAvgStarByGameId(gameId);

        return optional.orElse(0.0);
    }
}
