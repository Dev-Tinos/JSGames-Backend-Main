package com.example.jsgamesbackendmain.Model.DTO.ReportLog.Request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReportLogRequestDTO {
    private Long reportedLogId;
    private String reporterId;
}
