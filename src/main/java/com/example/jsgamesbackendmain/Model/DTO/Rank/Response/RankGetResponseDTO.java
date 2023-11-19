package com.example.jsgamesbackendmain.Model.DTO.Rank.Response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class RankGetResponseDTO {
    private LocalDateTime lastUpdated = LocalDateTime.now();
    private List<RankTop100UserResponseDTO> rankList;
}
