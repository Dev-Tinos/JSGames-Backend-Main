package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentDeleteResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentListResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentUpdateResponseDTO;
import com.example.jsgamesbackendmain.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping
@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 작성 API
    @PostMapping("/comment")
    public CommentCreateResponseDTO addComment(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO) {
        return commentService.createComment(commentCreateRequestDTO);
    }

    // 게임 별 댓글 조회 API
    @GetMapping("/comments/game/{gameId}")
    public CommentListResponseDTO listCommentsByGame(@PathVariable Long gameId) {
        return commentService.getCommentsByGame(gameId);
    }

    // 댓글 수정 API
    @PutMapping("/comment/{commentId}")
    public CommentUpdateResponseDTO updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDTO commentUpdateRequestDTO) {
        return commentService.modifyComment(commentId, commentUpdateRequestDTO);
    }

    // 댓글 삭제 API
    @DeleteMapping("/comment/{commentId}")
    public CommentDeleteResponseDTO deleteComment(@PathVariable Long commentId) {
        return commentService.removeComment(commentId);
    }
}
