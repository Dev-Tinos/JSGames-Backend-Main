package com.example.jsgamesbackendmain.Bean.CommentBean;

import com.example.jsgamesbackendmain.Model.DAO.CommentDAO;
import com.example.jsgamesbackendmain.Model.DTO.Comment.Response.CommentGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CommentListByGameBean {

    @Autowired
    private CommentRepository commentRepository;

    public List<CommentGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());

        Page<CommentDAO> all = commentRepository.findByGameIdOrderByDateTimeDesc(gameId, pageRequest);

        return all.toList().stream().map(CommentGetByGameIdResponseDTO::of).collect(Collectors.toList());
    }
}
