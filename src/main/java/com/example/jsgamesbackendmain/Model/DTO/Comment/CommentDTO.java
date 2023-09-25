package com.example.jsgamesbackendmain.Model.DTO.Comment;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentDTO {
    private Long commentId;
    private Long userId;
    private Long gameId;
    private String commentContent;
    private LocalDateTime dateTime;

    public static CommentDTO of(CommentDAO commentDAO) {
        CommentDTO dto = new CommentDTO();
        dto.setCommentId(commentDAO.getCommentId());
        dto.setUserId(commentDAO.getUserId());
        dto.setGameId(commentDAO.getGameId());
        dto.setCommentContent(commentDAO.getCommentContent());
        dto.setDateTime(commentDAO.getDateTime());
        return dto;
    }
}
