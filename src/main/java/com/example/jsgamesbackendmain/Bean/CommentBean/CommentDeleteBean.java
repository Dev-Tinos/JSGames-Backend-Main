package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Controller.ExceptionControll.ResourceNotFoundException;
import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDeleteResponseDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentDeleteBean {

    @Autowired
    private CommentRepository commentRepository;

    public CommentDeleteResponseDTO remove(Long commentId) {
        CommentDAO comment = commentRepository.findById(commentId).orElseThrow(() ->
                new ResourceNotFoundException("Comment not found for this id :: " + commentId)
        );

        commentRepository.delete(comment);
        CommentDeleteResponseDTO response = new CommentDeleteResponseDTO();
        response.setMessage("Successfully deleted the comment with id: " + commentId);
        return response;
    }
}
