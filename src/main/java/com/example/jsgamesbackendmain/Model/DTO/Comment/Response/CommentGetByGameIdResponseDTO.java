package com.example.jsgamesbackendmain.Model.DTO.Comment.Response;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CommentGetByGameIdResponseDTO {

    private Long commentId;
    private Long userId;
    private Long gameId;
    private String commentContent;
    private LocalDateTime dateTime;

    public static CommentGetByGameIdResponseDTO of(CommentDAO commentDAO) {
        CommentGetByGameIdResponseDTO commentGetByGameIdResponseDTO = new CommentGetByGameIdResponseDTO();

        commentGetByGameIdResponseDTO.setCommentId(commentDAO.getCommentId());
        commentGetByGameIdResponseDTO.setUserId(commentDAO.getUserId());
        commentGetByGameIdResponseDTO.setGameId(commentDAO.getGameId());
        commentGetByGameIdResponseDTO.setCommentContent(commentDAO.getCommentContent());
        commentGetByGameIdResponseDTO.setDateTime(commentDAO.getDateTime());

        return commentGetByGameIdResponseDTO;
    }

}
