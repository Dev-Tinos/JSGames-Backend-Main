package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.CommentBean.CommentListByGameBean;
import com.example.jsgamesbackendmain.Bean.CommentBean.CommentPostBean;
import com.example.jsgamesbackendmain.Bean.CommentBean.CommentUpdateBean;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<CommentGetByGameIdResponseDTO> listCommentsByGame(Long gameId, Long page, Long size) {
        return commentListByGameBean.exec(gameId, page, size);
    }

    // 댓글 수정
    public CommentDTO updateComment(Long commentId, CommentUpdateRequestDTO requestDTO) {
        return commentUpdateBean.exec(commentId, requestDTO);
    }
}
