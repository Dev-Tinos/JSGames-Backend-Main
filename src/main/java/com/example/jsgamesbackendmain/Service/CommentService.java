package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.CommentBean.*;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentListResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentPostBean commentCreateBean;

    @Autowired
    private CommentListByGameBean commentListByGameBean;

    @Autowired
    private CommentUpdateBean commentUpdateBean;

    // 댓글 작성
    public CommentDTO postComment(CommentCreateRequestDTO requestDTO) {
        return commentCreateBean.exec(requestDTO);
    }

    // 게임 별 댓글 조회
    public CommentListResponseDTO listCommentsByGame(Long gameId) {
        return commentListByGameBean.exec(gameId);
    }

    // 댓글 수정
    public CommentDTO updateComment(Long commentId, CommentUpdateRequestDTO requestDTO) {
        return commentUpdateBean.exec(commentId, requestDTO);
    }
}
