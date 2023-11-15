package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewSaveSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import com.example.jsgamesbackendmain.Repository.ReviewRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewPostBean {

    @Autowired
    private ReviewSaveSmallBean reviewSaveSmallBean;
    @Autowired
    private MapperBean mapperBean;

    public ReviewDTO exec(ReviewCreateRequestDTO requestDTO) {

        ReviewDAO dao = mapperBean.to(requestDTO, ReviewDAO.class);

        ReviewDAO savedDao = reviewSaveSmallBean.exec(dao);

        return mapperBean.to(savedDao, ReviewCreateResponseDTO.class);
    }
}
