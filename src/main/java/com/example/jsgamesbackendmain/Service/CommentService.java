package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.CommentBean.*;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentDeleteResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentUpdateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

    @Autowired
    private CommentCreateBean commentCreateBean;

    @Autowired
    private CommentListByGameBean commentListByGameBean;

    @Autowired
    private CommentUpdateBean commentUpdateBean;

    @Autowired
    private CommentDeleteBean commentDeleteBean;

    // 댓글 작성
    public CommentCreateResponseDTO createComment(CommentCreateRequestDTO requestDTO) {
        return commentCreateBean.create(requestDTO);
    }

    // 게임 별 댓글 조회
    public CommentListResponseDTO getCommentsByGame(Long gameId) {
        return commentListByGameBean.getByGame(gameId);
    }

    // 댓글 수정
    public CommentUpdateResponseDTO modifyComment(Long commentId, CommentUpdateRequestDTO requestDTO) {
        return commentUpdateBean.modify(commentId, requestDTO);
    }

    // 댓글 삭제
    public CommentDeleteResponseDTO removeComment(Long commentId) {
        return commentDeleteBean.remove(commentId);
    }
}
