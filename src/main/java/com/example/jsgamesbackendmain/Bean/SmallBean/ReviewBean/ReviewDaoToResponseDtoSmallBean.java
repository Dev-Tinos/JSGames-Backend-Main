package com.example.jsgamesbackendmain.Bean.SmallBean.ReviewBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.Review.Response.ReviewGetByGameIdResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReviewDaoToResponseDtoSmallBean {

    @Autowired
    private MapperBean mapperBean;

    @Autowired
    private UserGetSmallBean userGetSmallBean;

    public ReviewGetByGameIdResponseDTO exec(ReviewDAO dao) {
        ReviewGetByGameIdResponseDTO dto = mapperBean.to(dao, ReviewGetByGameIdResponseDTO.class);

        UserDAO user = userGetSmallBean.getUser(dao.getUserId());

        UserGetResponseDTO userDTO = mapperBean.to(user, UserGetResponseDTO.class);

        dto.setUser(userDTO);

        return dto;
    }
}
