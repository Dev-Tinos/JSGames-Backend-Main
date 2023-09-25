package com.example.jsgamesbackendmain.Model.DTO.Comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDeleteResponseDTO {
    private String message;

    public static CommentDeleteResponseDTO success() {
        CommentDeleteResponseDTO response = new CommentDeleteResponseDTO();
        response.setMessage("Comment deleted successfully.");
        return response;
    }
}
