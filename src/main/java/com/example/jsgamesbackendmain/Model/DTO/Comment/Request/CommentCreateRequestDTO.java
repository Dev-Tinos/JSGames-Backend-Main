package com.example.jsgamesbackendmain.Model.DTO.Comment.Request;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateRequestDTO {
    private Long userId;
    private Long gameId;
    private String commentContent;

    public static CommentDAO toDAO(CommentCreateRequestDTO requestDTO) {
        CommentDAO comment = new CommentDAO();
        comment.setUserId(requestDTO.getUserId());
        comment.setGameId(requestDTO.getGameId());
        comment.setCommentContent(requestDTO.getCommentContent());
        return comment;
    }
}
