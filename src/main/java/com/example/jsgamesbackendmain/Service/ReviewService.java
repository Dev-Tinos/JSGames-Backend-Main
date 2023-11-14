package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewListByGameBean;
import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewPostBean;
import com.example.jsgamesbackendmain.Bean.ReviewBean.ReviewUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
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

    // 댓글 작성
    public ReviewDTO postReview(ReviewCreateRequestDTO requestDTO) {
        return reviewCreateBean.exec(requestDTO);
    }

    // 게임 별 댓글 조회
    public List<ReviewGetByGameIdResponseDTO> listReviewsByGame(Long gameId, Long page, Long size) {
        return reviewListByGameBean.exec(gameId, page, size);
    }

    // 댓글 수정
    public ReviewDTO updateReview(Long reviewId, ReviewUpdateRequestDTO requestDTO) {
        return reviewUpdateBean.exec(reviewId, requestDTO);
    }
}
