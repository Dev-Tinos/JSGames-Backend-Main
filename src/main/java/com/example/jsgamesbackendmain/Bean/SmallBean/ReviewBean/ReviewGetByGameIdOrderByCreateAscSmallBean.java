package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ReviewGetByGameIdOrderByCreateAscSmallBean {
    private final ReviewRepository reviewRepository;

    public List<ReviewDAO> exec(Long gameId, PageRequest pageRequest) {
        Page<ReviewDAO> order = reviewRepository.findByGameIdOrderByDateTimeAscReviewIdDesc(gameId, pageRequest);

        return order.toList();
    }
}
