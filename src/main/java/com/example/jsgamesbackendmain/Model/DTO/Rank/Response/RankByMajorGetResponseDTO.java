package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankByMajorGetResponseDTO {
    @Builder.Default
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private List<RankByMajorUserResponseDTO> rankList;
}
