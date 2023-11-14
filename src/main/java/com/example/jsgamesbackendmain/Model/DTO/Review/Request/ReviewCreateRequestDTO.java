package com.example.jsgamesbackendmain.Model.DTO.Review.Request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewCreateRequestDTO {
    private Long userId;
    private Long gameId;
    private String reviewContent;
    // 별점
    private Float star;
    // helpful
    private Float helpful;

//    public static CommentDAO toDAO(CommentCreateRequestDTO requestDTO) {
//        CommentDAO comment = new CommentDAO();
//        comment.setUserId(requestDTO.getUserId());
//        comment.setGameId(requestDTO.getGameId());
//        comment.setCommentContent(requestDTO.getCommentContent());
//        return comment;
//    }
}
