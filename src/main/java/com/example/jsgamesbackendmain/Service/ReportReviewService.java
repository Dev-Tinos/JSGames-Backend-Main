package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.ReportReviewBean.PostReportReview;
import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Request.ReportReviewPostRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.ReportReview.Response.ReportReviewPostResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReportReviewService {
    private final PostReportReview reportReviewSaveBean;
    public ReportReviewPostResponseDTO reportReview(ReportReviewPostRequestDTO request) {
        return reportReviewSaveBean.exec(request);
    }
}
