package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    // 리뷰 작성 API
    @Operation(summary = "리뷰 작성")
    @PostMapping("/review")
    public ReviewDTO postReview(@RequestBody ReviewCreateRequestDTO reviewCreateRequestDTO) {
        return reviewService.postReview(reviewCreateRequestDTO);
    }

    // 게임 별 리뷰 조회 API
    @Operation(summary = "리뷰 조회", description =
            "# 게임 별 리뷰 조회  \n" +
            "먼저 작성된 리뷰 -> 나중에 작성된 리뷰 순서대로 정렬됨"
    )
    @GetMapping("/review/game/{gameId}")
    public List<ReviewGetByGameIdResponseDTO> listReviewsByGame(@PathVariable Long gameId, @Parameter Long page, @Parameter Long size) {
        return reviewService.listReviewsByGame(gameId, page, size);
    }

    // 리뷰 수정 API
    @Operation(summary = "리뷰 수정")
    @PutMapping("/review/{reviewId}")
    public ReviewDTO updateReview(@PathVariable Long reviewId, @RequestBody ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        return reviewService.updateReview(reviewId, reviewUpdateRequestDTO);
    }
}
