package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentListResponseDTO;
import com.example.jsgamesbackendmain.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CommentController {
    @Autowired
    private CommentService commentService;

    // 댓글 작성 API
    @Operation(summary = "Post Comment")
    @PostMapping("/comment")
    public CommentDTO postComment(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO) {
        return commentService.postComment(commentCreateRequestDTO);
    }

    // 게임 별 댓글 조회 API
    @Operation(summary = "Get List Comment By Game")
    @GetMapping("/comments/game/{gameId}")
    public CommentListResponseDTO listCommentsByGame(@PathVariable Long gameId) {
        return commentService.listCommentsByGame(gameId);
    }

    // 댓글 수정 API
    @Operation(summary = "Update Comment")
    @PutMapping("/comment/{commentId}")
    public CommentDTO updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDTO commentUpdateRequestDTO) {
        return commentService.updateComment(commentId, commentUpdateRequestDTO);
    }
}
