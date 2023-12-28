package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReviewSaveSmallBean {
    private final ReviewRepository reviewRepository;

    public ReviewDAO exec(ReviewDAO dao) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserIdAndGameId(dao.getUserId(), dao.getGameId());

        //존재한다면 이미 존재하는 리뷰 에러
        if (optional.isPresent()) {
            throw new InvalidException("Review already exists for Game id,UserId :: " + dao.getGameId() + "," + dao.getUserId());
        }

        return reviewRepository.save(dao);
    }
}
