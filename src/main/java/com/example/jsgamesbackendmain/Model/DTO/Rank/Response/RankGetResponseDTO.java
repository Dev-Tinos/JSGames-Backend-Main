package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RankGetResponseDTO {
    @Builder.Default
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private List<RankTop100UserResponseDTO> rankList;
}
