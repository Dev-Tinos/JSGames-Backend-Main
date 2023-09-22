package com.example.jsgamesbackendmain.Model.DTO.Result;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ResultPostDTO {

        private Long userId;
        private Long gameId;
        private Double gameScore;

        public static ResultDAO toDAO(ResultPostDTO resultPostDTO) {
            ResultDAO resultDAO = new ResultDAO();
            resultDAO.setUserId(resultPostDTO.getUserId());
            resultDAO.setGameId(resultPostDTO.getGameId());
            resultDAO.setGameScore(resultPostDTO.getGameScore());

            return resultDAO;
        }
}
