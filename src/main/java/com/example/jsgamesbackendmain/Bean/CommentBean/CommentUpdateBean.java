package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentUpdateBean {

    @Autowired
    private CommentRepository commentRepository;

    public CommentDTO exec(Long commentId, CommentUpdateRequestDTO requestDTO) {
        CommentDAO comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found for this id :: " + commentId)
        );

        comment.setCommentContent(requestDTO.getCommentContent());

        CommentDAO updatedComment = commentRepository.save(comment);

        return CommentDTO.of(updatedComment);
    }
}
