package com.example.jsgamesbackendmain.Controller;

import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Request.CommentUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Service.CommentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class CommentController {

    @Autowired
    private CommentService commentService;

    // 댓글 작성 API
    @Operation(summary = "댓글 작성")
    @PostMapping("/comment")
    public CommentDTO postComment(@RequestBody CommentCreateRequestDTO commentCreateRequestDTO) {
        return commentService.postComment(commentCreateRequestDTO);
    }

    // 게임 별 댓글 조회 API
    @Operation(summary = "댓글 조회", description =
            "# 게임 별 댓글 조회  \n" +
            "먼저 작성된 댓글 -> 나중에 작성된 댓글 순서대로 정렬됨"
    )
    @GetMapping("/comments/game/{gameId}")
    public List<CommentGetByGameIdResponseDTO> listCommentsByGame(@PathVariable Long gameId, @Parameter Long page, @Parameter Long size) {
        return commentService.listCommentsByGame(gameId, page, size);
    }

    // 댓글 수정 API
    @Operation(summary = "댓글 수정")
    @PutMapping("/comment/{commentId}")
    public CommentDTO updateComment(@PathVariable Long commentId, @RequestBody CommentUpdateRequestDTO commentUpdateRequestDTO) {
        return commentService.updateComment(commentId, commentUpdateRequestDTO);
    }
}
