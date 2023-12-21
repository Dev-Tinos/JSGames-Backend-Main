package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewGetByUserIdAndGameIdSmallBean {
    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDAO exec(String userId, Long gameId) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserIdAndGameId(userId, gameId);
        // 존재하지 않는다면
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Review not found for Game id,UserId :: " + gameId + "," + userId);
        }

        return optional.get();
    }
}
