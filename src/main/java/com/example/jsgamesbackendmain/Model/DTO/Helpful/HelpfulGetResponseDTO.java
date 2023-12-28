package com.example.jsgamesbackendmain.Model.DTO.Helpful;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HelpfulGetResponseDTO {
    private boolean helpful;
}
