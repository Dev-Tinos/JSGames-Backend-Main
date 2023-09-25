package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentCreateResponseDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CommentCreateBean {

    @Autowired
    private CommentRepository commentRepository;

    public CommentCreateResponseDTO create(CommentCreateRequestDTO requestDTO) {
        CommentDAO comment = CommentCreateRequestDTO.toDAO(requestDTO);
        CommentDAO savedComment = commentRepository.save(comment);

        return CommentCreateResponseDTO.success(savedComment);
    }
}
