package com.example.jsgamesbackendmain.Model.DTO.Review.Response;


import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReviewCreateResponseDTO extends ReviewDTO {
    private String userId;
    private Long gameId;
}
