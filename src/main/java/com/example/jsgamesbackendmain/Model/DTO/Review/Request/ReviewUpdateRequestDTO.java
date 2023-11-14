package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewUpdateRequestDTO {
    private String reviewContent;
}