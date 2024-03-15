package com.example.jsgamesbackendmain.Model.DTO.ReportReview.Response;

import com.example.jsgamesbackendmain.Model.DAO.ReportReviewDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ReportReviewPostResponseDTO {
    private Long reportReviewId;
    private LocalDateTime createAt;

    public static ReportReviewPostResponseDTO of(ReportReviewDAO reportReview){
        return ReportReviewPostResponseDTO.builder()
                .reportReviewId(reportReview.getReportReviewId())
                .createAt(reportReview.getCreatedAt())
                .build();
    }
}
