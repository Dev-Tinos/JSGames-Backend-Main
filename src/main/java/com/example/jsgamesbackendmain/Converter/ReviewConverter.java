package com.example.jsgamesbackendmain.Converter;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;

public class ReviewConverter {
    public static ReviewGetByGameIdResponseDTO toGetByGameIdResponseDTO(ReviewDAO dao, UserGetResponseDTO userGetResponseDTO) {
        ReviewGetByGameIdResponseDTO dto = new ReviewGetByGameIdResponseDTO();

        dto.setReviewId(dao.getReviewId());
        dto.setReviewContent(dao.getReviewContent());
        dto.setStar(dao.getStar());
        dto.setHelpful(dao.getHelpful());
        dto.setDateTime(dao.getDateTime());
        dto.setGameId(dao.getGameId());

        dto.setUser(userGetResponseDTO);

        return dto;
    }
}
