package com.example.jsgamesbackendmain.Model.DTO.ReportLog.Response;

import com.example.jsgamesbackendmain.Model.DAO.ReportLogDAO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class ReportLogResponseDTO {
    private Long reportLogId;
    private LocalDateTime createAt;

    public static ReportLogResponseDTO of(ReportLogDAO reportLog){
        return ReportLogResponseDTO.builder()
                .reportLogId(reportLog.getReportLogId())
                .createAt(reportLog.getCreatedAt())
                .build();
    }
}
