package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.*;
import com.example.jsgamesbackendmain.Controller.ReviewController;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
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

    public List<ReviewGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size, ReviewSort sort) {

        PageRequest request = PageRequest.of(page.intValue(), size.intValue());


        List<ReviewDAO> daos = null;

        switch (sort){
            case RECENT:
                daos = reviewGetByGameIdOrderByCreateDescSmallBean.exec(gameId, request);
                break;
            case OLDEST:
                daos = reviewGetByGameIdOrderByCreateAscSmallBean.exec(gameId, request);
                break;
            case STAR:
                daos = reviewGetByGameIdOrderByStarDescSmallBean.exec(gameId, request);
                break;
            case HELPFUL:
                daos = reviewGetByGameIdOrderByHelpfulSmallBean.exec(gameId, request);
                break;
        }

        return daos.stream().map(dao -> reviewDaoToResponseDtoSmallBean.exec(dao)).collect(Collectors.toList());
    }
}
