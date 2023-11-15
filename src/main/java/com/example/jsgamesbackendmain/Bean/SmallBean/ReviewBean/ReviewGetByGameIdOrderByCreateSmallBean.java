package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReviewGetByGameIdOrderByCreateSmallBean {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<ReviewDAO> exec(Long gameId, Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        Page<ReviewDAO> order = reviewRepository.findByGameIdOrderByDateTimeAsc(gameId, pageRequest);

        return order.toList();
    }
}
