package com.example.jsgamesbackendmain.Model.DTO.Comment;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentUpdateResponseDTO {
    private String message;
    private CommentDTO data;

    public static CommentUpdateResponseDTO success(CommentDAO commentDAO) {
        CommentUpdateResponseDTO response = new CommentUpdateResponseDTO();
        response.setMessage("Comment updated successfully.");
        response.setData(CommentDTO.of(commentDAO));
        return response;
    }

}
