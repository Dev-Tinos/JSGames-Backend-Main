package com.example.jsgamesbackendmain.Bean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.GameBean.GameGetSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByGameIdOrderByCreateAscSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByGameIdOrderByCreateDescSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByGameIdOrderByHelpfulSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean.ReviewGetByGameIdOrderByStarDescSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ReviewSort;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ReviewListByGameBean {

    private final ReviewGetByGameIdOrderByHelpfulSmallBean reviewGetByGameIdOrderByHelpfulSmallBean;
    private final ReviewGetByGameIdOrderByCreateDescSmallBean reviewGetByGameIdOrderByCreateDescSmallBean;
    private final ReviewGetByGameIdOrderByCreateAscSmallBean reviewGetByGameIdOrderByCreateAscSmallBean;
    private final ReviewGetByGameIdOrderByStarDescSmallBean reviewGetByGameIdOrderByStarDescSmallBean;

    private final GameGetSmallBean gameGetSmallBean;


    public List<ReviewGetByGameIdResponseDTO> exec(Long gameId, Integer page, Integer size, ReviewSort sort) {

        PageRequest request = PageRequest.of(page, size);

        GameDAO findGame = gameGetSmallBean.exec(gameId);


        List<ReviewDAO> reviewList = null;

        switch (sort) {
            case RECENT:
                reviewList = reviewGetByGameIdOrderByCreateDescSmallBean.exec(findGame, request);
                break;
            case OLDEST:
                reviewList = reviewGetByGameIdOrderByCreateAscSmallBean.exec(findGame, request);
                break;
            case STAR:
                reviewList = reviewGetByGameIdOrderByStarDescSmallBean.exec(findGame, request);
                break;
            case HELPFUL:
                reviewList = reviewGetByGameIdOrderByHelpfulSmallBean.exec(findGame, request);
                break;
        }

        return reviewList.stream()
                .map(ReviewGetByGameIdResponseDTO::of)
                .collect(Collectors.toList());
    }
}
