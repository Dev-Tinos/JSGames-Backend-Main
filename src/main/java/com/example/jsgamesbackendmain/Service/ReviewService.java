package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewGetMyReviewBean;
import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewListByGameBean;
import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewPostBean;
import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    private ReviewPostBean reviewCreateBean;

    @Autowired
    private ReviewListByGameBean reviewListByGameBean;

    @Autowired
    private ReviewUpdateBean reviewUpdateBean;

    @Autowired
    private ReviewGetMyReviewBean reviewGetMyReviewBean;

    // 본인이 작성한 리뷰 조회
    public ReviewDTO getMyReview(Long gameId, String userId) {
        return reviewGetMyReviewBean.exec(gameId, userId);
    }

    // 리뷰 작성
    public ReviewDTO postReview(ReviewCreateRequestDTO requestDTO) {
        return reviewCreateBean.exec(requestDTO);
    }

    // 게임 별 리뷰 조회
    public List<ReviewGetByGameIdResponseDTO> listReviewsByGame(Long gameId, Long page, Long size, ReviewSort sort) {
        return reviewListByGameBean.exec(gameId, page, size, sort);
    }

    // 리뷰 수정
    public ReviewUpdateResponseDTO updateReview(Long reviewId, ReviewUpdateRequestDTO requestDTO) {
        return reviewUpdateBean.exec(reviewId, requestDTO);
    }
}
