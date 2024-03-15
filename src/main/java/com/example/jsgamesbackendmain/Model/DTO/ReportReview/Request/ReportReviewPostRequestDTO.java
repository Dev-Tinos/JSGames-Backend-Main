package com.example.jsgamesbackendmain.Model.DTO.ReportReview.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class ReportReviewPostRequestDTO {
    private Long reportedReviewId;
    private String reporterId;
}
