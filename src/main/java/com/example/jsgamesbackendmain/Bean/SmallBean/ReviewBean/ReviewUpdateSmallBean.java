package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.InvalidException;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ReviewUpdateSmallBean {
    @Autowired
    private ReviewRepository reviewRepository;
    public ReviewDAO exec(ReviewDAO dao) {
        Optional<ReviewDAO> optional = reviewRepository.findByUserIdAndGameId(dao.getUserId(), dao.getGameId());

        //존재하지 않는다면 리뷰 업데이트 에러
        if (!optional.isPresent()) {
            throw new InvalidException("Review not exists for Game id,UserId :: " + dao.getGameId() + "," + dao.getUserId());
        }

        return reviewRepository.save(dao);
    }

}
