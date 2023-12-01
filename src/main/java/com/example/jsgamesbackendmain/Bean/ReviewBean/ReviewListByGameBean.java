package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.*;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewListByGameBean {

    @Autowired
    private ReviewGetByGameIdOrderByHelpfulSmallBean reviewGetByGameIdOrderByHelpfulSmallBean;
    @Autowired
    private ReviewGetByGameIdOrderByCreateDescSmallBean reviewGetByGameIdOrderByCreateDescSmallBean;
    @Autowired
    private ReviewGetByGameIdOrderByCreateAscSmallBean reviewGetByGameIdOrderByCreateAscSmallBean;
    @Autowired
    private ReviewGetByGameIdOrderByStarDescSmallBean reviewGetByGameIdOrderByStarDescSmallBean;

    @Autowired
    private ReviewDaoToResponseDtoSmallBean reviewDaoToResponseDtoSmallBean;

    public List<ReviewGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size, String sort) {

        PageRequest request = PageRequest.of(page.intValue(), size.intValue());


        List<ReviewDAO> daos = null;

        if(sort.equals("oldest")){
            daos = reviewGetByGameIdOrderByCreateAscSmallBean.exec(gameId, request);
        } else if(sort.equals("star")){
            daos = reviewGetByGameIdOrderByStarDescSmallBean.exec(gameId, request);
        } else if(sort.equals("helpful")){
            daos = reviewGetByGameIdOrderByHelpfulSmallBean.exec(gameId, request);
        } else {
            daos = reviewGetByGameIdOrderByCreateDescSmallBean.exec(gameId, request);
        }

        return daos.stream().map(dao -> reviewDaoToResponseDtoSmallBean.exec(dao)).collect(Collectors.toList());
    }
}
