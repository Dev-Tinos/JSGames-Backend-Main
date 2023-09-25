package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentUpdateResponseDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentUpdateBean {

    @Autowired
    private CommentRepository commentRepository;

    public CommentUpdateResponseDTO modify(Long commentId, CommentUpdateRequestDTO requestDTO) {
        CommentDAO comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found for this id :: " + commentId)
        );

        comment.setCommentContent(requestDTO.getCommentContent());

        CommentDAO updatedComment = commentRepository.save(comment);

        return CommentUpdateResponseDTO.success(updatedComment);
    }
}
