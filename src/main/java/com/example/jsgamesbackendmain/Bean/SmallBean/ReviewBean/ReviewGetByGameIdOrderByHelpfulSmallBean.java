package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewGetByGameIdOrderByHelpfulSmallBean {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDAO> exec(Long gameId, PageRequest pageRequest) {
        Page<ReviewDAO> order = reviewRepository.findByGameIdOrderByHelpfulDescDateTimeDesc(gameId, pageRequest);

        return order.toList();
    }
}
