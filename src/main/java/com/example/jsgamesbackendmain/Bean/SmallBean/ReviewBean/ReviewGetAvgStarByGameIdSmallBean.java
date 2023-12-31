package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewGetAvgStarByGameIdSmallBean {
    private final ReviewRepository reviewRepository;

    public Double exec(GameDAO game) {
        Optional<Double> optional = reviewRepository.findAvgStarByGame(game);

        return optional.orElse(0.0);
    }
}
