package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewGetByGameIdOrderByCreateDescSmallBean {
    private final ReviewRepository reviewRepository;

    public List<ReviewDAO> exec(GameDAO game, PageRequest pageRequest) {
        Page<ReviewDAO> order = reviewRepository.findByGameOrderByDateTimeDescReviewIdDesc(game, pageRequest);

        return order.toList();
    }
}
