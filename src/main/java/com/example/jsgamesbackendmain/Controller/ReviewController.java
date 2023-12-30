package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
import com.example.jsgamesbackendmain.Service.ReviewService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class ReviewController {

    private final ReviewService reviewService;

    // 본인이 작성한 리뷰 조회 API
    @Operation(summary = "본인이 작성한 리뷰 조회", description =
            "본인이 작성한 리뷰 조회 \n\n " +
                    "없다면 404 에러가 발생합니다."
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "리뷰 조회 성공"),
            @ApiResponse(responseCode = "404", description = "리뷰가 없는경우", content = @Content(schema = @Schema(implementation = Map.class)))
    })
    @Parameters({
            @Parameter(name = "userId", description = "유저 아이디", required = true),
            @Parameter(name = "gameId", description = "게임 아이디", required = true)
    })
    @GetMapping("/review/game/{gameId}/user/{userId}")
    public ReviewGetByGameIdResponseDTO getMyReview(
            @PathVariable Long gameId,
            @PathVariable String userId
    ) {
        return reviewService.getMyReview(gameId, userId);
    }

    // 리뷰 작성 API
    @Operation(summary = "리뷰 작성")
    @PostMapping("/review")
    public ReviewCreateResponseDTO postReview(@RequestBody ReviewCreateRequestDTO reviewCreateRequestDTO) {
        return reviewService.postReview(reviewCreateRequestDTO);
    }

    // 게임 별 리뷰 조회 API
    @Operation(summary = "리뷰 조회", description =
            "# 게임 별 리뷰 조회  \n\n " +
                    "지원되는 정렬 옵션: '최근순', '오래된순', '별점순', '도움 순' \n\n " +
                    "RECENT: 최근순 \n\n " +
                    "OLDEST: 오래된순 \n\n " +
                    "STAR: 별점순 \n\n " +
                    "HELPFUL: 도움 순 \n\n " +
                    "기본 정렬은 '최근순'."
    )
    @Parameters({
            @Parameter(name = "gameId", description = "게임 아이디", required = true),
            @Parameter(name = "page", description = "페이지 번호", required = true),
            @Parameter(name = "size", description = "페이지 사이즈", required = true),
            @Parameter(name = "sort", description = "정렬 옵션", required = true)
    })
    @GetMapping("/review/game/{gameId}")
    public List<ReviewGetByGameIdResponseDTO> listReviewsByGame(
            @PathVariable Long gameId,
            @RequestParam Integer page,
            @RequestParam Integer size,
            @RequestParam(defaultValue = "RECENT") ReviewSort sort) {
        return reviewService.listReviewsByGame(gameId, page, size, sort);
    }

    // 리뷰 수정 API
    @Operation(summary = "리뷰 수정")
    @PutMapping("/review/{reviewId}")
    public ReviewUpdateResponseDTO updateReview(@PathVariable Long reviewId, @RequestBody ReviewUpdateRequestDTO reviewUpdateRequestDTO) {
        return reviewService.updateReview(reviewId, reviewUpdateRequestDTO);
    }
}
