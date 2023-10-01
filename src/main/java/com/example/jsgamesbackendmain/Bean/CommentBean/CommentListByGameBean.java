package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentListResponseDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommentListByGameBean {

    @Autowired
    private CommentRepository commentRepository;

    public CommentListResponseDTO exec(Long gameId) {
        List<CommentDAO> comments = commentRepository.findAllByGameId(gameId);
        return CommentListResponseDTO.of(comments);
    }
}
