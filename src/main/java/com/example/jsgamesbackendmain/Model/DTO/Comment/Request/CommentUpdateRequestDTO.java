package com.example.jsgamesbackendmain.Model.DTO.Comment.Request;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateRequestDTO {
    private String commentContent;

    public void updateComment(CommentDAO commentDAO) {
        commentDAO.setCommentContent(this.commentContent);
    }
}
