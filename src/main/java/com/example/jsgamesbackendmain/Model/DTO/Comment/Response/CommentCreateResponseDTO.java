package com.example.jsgamesbackendmain.Model.DTO.Comment.Response;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentCreateResponseDTO {
    private String message;
    private CommentDTO data;

    public static CommentCreateResponseDTO success(CommentDAO commentDAO) {
        CommentCreateResponseDTO response = new CommentCreateResponseDTO();
        response.setMessage("Comment created successfully.");
        response.setData(CommentDTO.of(commentDAO));
        return response;
    }

}
