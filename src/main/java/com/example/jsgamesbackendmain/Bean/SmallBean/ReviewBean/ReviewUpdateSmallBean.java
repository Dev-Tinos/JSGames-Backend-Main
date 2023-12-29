package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewUpdateSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(ReviewDAO review, ReviewUpdateRequestDTO request) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserAndGame(review.getUser().getUserId(), review.getGame().getGameId());

        //존재하지 않는다면 리뷰 업데이트 에러
        if (!optional.isPresent()) {
            throw new InvalidException("Review not exists for Game id,UserId :: " + review.getGame().getGameId() + "," + review.getUser().getUserId());
        }

        // 리뷰 내용 업데이트
        review.update(request);

        return reviewRepository.save(review);
    }

}
