package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ReviewBean.GetReviewByGameIdAndUserId;
import com.example.jsgamesbackendmain.Bean.ReviewBean.GetReviewsByGameId;
import com.example.jsgamesbackendmain.Bean.ReviewBean.PostReview;
import com.example.jsgamesbackendmain.Bean.ReviewBean.UpdateReview;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final PostReview reviewCreateBean;

    private final GetReviewsByGameId reviewListByGameBean;

    private final UpdateReview reviewUpdateBean;

    private final GetReviewByGameIdAndUserId reviewGetMyReviewBean;

    // 본인이 작성한 리뷰 조회
    @Transactional
    public ReviewGetByGameIdResponseDTO getMyReview(Long gameId, String userId) {
        return reviewGetMyReviewBean.exec(gameId, userId);
    }

    // 리뷰 작성
    @Transactional
    public ReviewCreateResponseDTO postReview(ReviewCreateRequestDTO requestDTO) {
        return reviewCreateBean.exec(requestDTO);
    }

    // 게임 별 리뷰 조회
    @Transactional
    public List<ReviewGetByGameIdResponseDTO> listReviewsByGame(Long gameId, Integer page, Integer size, ReviewSort sort) {
        return reviewListByGameBean.exec(gameId, page, size, sort);
    }

    // 리뷰 수정
    @Transactional
    public ReviewUpdateResponseDTO updateReview(Long reviewId, ReviewUpdateRequestDTO requestDTO) {
        return reviewUpdateBean.exec(reviewId, requestDTO);
    }
}
