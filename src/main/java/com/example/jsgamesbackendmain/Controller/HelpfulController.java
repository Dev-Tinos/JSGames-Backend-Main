package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Helpful.HelpfulGetResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import com.example.jsgamesbackendmain.Service.HelpfulService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class HelpfulController {
    private final HelpfulService helpfulService;

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 조회 API
    @Operation(summary = "helpful 여부 조회")
    @GetMapping("/helpful/user/{userId}/review/{reviewId}")
    public HelpfulGetResponseDTO getHelpful(String userId, Long reviewId) {
        return helpfulService.getHelpful(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 추가 API
    @Operation(summary = "helpful 추가")
    @PostMapping("/helpful/user/{userId}/review/{reviewId}")
    public StateResponseDTO postHelpful(String userId, Long reviewId) {
        return helpfulService.postHelpful(userId, reviewId);
    }

    // 특정 유저와 특정 리뷰의 도움이 되었는지 여부 삭제 API
    @Operation(summary = "helpful 삭제")
    @DeleteMapping("/helpful/user/{userId}/review/{reviewId}")
    public StateResponseDTO deleteHelpful(String userId, Long reviewId) {
        return helpfulService.deleteHelpful(userId, reviewId);
    }
}
