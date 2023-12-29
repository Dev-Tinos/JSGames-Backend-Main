package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewSaveSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(ReviewDAO review, UserDAO user, GameDAO game) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserAndGame(user, game);

        //존재한다면 이미 존재하는 리뷰 에러
        if (optional.isPresent()) {
            ReviewDAO findReview = optional.get();
            throw new InvalidException("Review already exists for Game id,UserId :: " + findReview.getGame().getGameId() + "," + findReview.getUser().getUserId());
        }

        review.setUser(user);
        review.setGame(game);

        return reviewRepository.save(review);
    }
}
