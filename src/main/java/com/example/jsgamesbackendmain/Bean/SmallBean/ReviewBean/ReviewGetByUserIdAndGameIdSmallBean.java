package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewGetByUserIdAndGameIdSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(UserDAO user, GameDAO game) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserAndGame(user, game);
        // 존재하지 않는다면
        if (!optional.isPresent()) {
            throw new ResourceNotFoundException("Review not found for Game id,UserId :: " + game.getGameId() + "," + user.getUserId());
        }

        return optional.get();
    }
}
