package com.example.jsgamesbackendmain.Model.DTO.Comment.Response;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.CommentDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CommentListResponseDTO {
    private String message;
    private List<CommentDTO> data;

    public static CommentListResponseDTO of(List<CommentDAO> commentList) {
        CommentListResponseDTO response = new CommentListResponseDTO();
        response.setMessage("Comments fetched successfully.");
        response.setData(commentList.stream().map(CommentDTO::of).collect(Collectors.toList()));
        return response;
    }

}
