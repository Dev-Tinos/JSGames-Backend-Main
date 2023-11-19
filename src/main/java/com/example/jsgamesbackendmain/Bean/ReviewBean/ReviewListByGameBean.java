package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewDaoToResponseDtoSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByGameIdOrderByCreateSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ReviewListByGameBean {

    @Autowired
    private ReviewGetByGameIdOrderByCreateSmallBean reviewGetByGameIdOrderByCreateSmallBean;

    @Autowired
    private ReviewDaoToResponseDtoSmallBean reviewDaoToResponseDtoSmallBean;

    public List<ReviewGetByGameIdResponseDTO> exec(Long gameId, Long page, Long size) {

        List<ReviewDAO> daos = reviewGetByGameIdOrderByCreateSmallBean.exec(gameId, page, size);

        return daos.stream().map(dao -> reviewDaoToResponseDtoSmallBean.exec(dao)).collect(Collectors.toList());
    }
}
