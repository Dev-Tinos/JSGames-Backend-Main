package com.example.jsgamesbackendmain.Model.DTO.UserWeight;

import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RankWeightDTO {
    private Long userId;

    private Long weightSum;
}
