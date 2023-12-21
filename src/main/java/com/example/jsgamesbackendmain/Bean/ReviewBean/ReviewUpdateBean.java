package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByIdSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewUpdateSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewUpdateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewUpdateBean {

    @Autowired
    private ReviewGetByIdSmallBean reviewGetByIdSmallBean;

    @Autowired
    private ReviewUpdateSmallBean reviewUpdateSmallBean;

    @Autowired
    private MapperBean mapperBean;

    public ReviewUpdateResponseDTO exec(Long reviewId, ReviewUpdateRequestDTO requestDTO) {

        ReviewDAO dao = reviewGetByIdSmallBean.exec(reviewId);

        dao = reviewUpdateSmallBean.exec(dao);

        return mapperBean.to(dao, ReviewUpdateResponseDTO.class);
    }
}

