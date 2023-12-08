package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewSaveSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Request.ReviewCreateRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewCreateResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.Review.ReviewDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewPostBean {

    @Autowired
    private ReviewSaveSmallBean reviewSaveSmallBean;
    @Autowired
    private UserGetByIdSmallBean userGetByIdSmallBean;
    @Autowired
    private GameGetSmallBean gameGetSmallBean;

    @Autowired
    private MapperBean mapperBean;

    public ReviewDTO exec(ReviewCreateRequestDTO requestDTO) {

        userGetByIdSmallBean.exec(requestDTO.getUserId());

        gameGetSmallBean.exec(requestDTO.getGameId());

        ReviewDAO dao = mapperBean.to(requestDTO, ReviewDAO.class);

        ReviewDAO savedDao = reviewSaveSmallBean.exec(dao);

        return mapperBean.to(savedDao, ReviewCreateResponseDTO.class);
    }
}
