package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Request.ReportReviewPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Response.ReportReviewPostResponseDTO;
import com.example.jsgamesbackendmain.Service.ReportReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportReviewController {
    private final ReportReviewService reportReviewService;

    @PostMapping("/review")
    public ReportReviewPostResponseDTO reportReview(
            @RequestBody ReportReviewPostRequestDTO request
    ) {
        return reportReviewService.reportReview(request);
    }
}
