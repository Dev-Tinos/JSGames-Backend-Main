package com.example.jsgamesbackendmain.Bean.SmallBean.RankBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.Rank.Response.RankTop100UserResponseDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserLogResponseDTO;
import com.example.jsgamesbackendmain.Repository.RankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class RankGetTop100SmallBean {
    @Autowired
    private RankRepository rankRepository;
    @Autowired
    private UserGetByIdSmallBean userGetByIdSmallBean;
    @Autowired
    private MapperBean mapperBean;

    public List<RankTop100UserResponseDTO> exec(Long page, Long size) {
        PageRequest pageRequest = PageRequest.of(page.intValue(), size.intValue());
        List<RankTop100DAO> list = rankRepository.findAllByOrderByTotalRankAsc(pageRequest).toList();
        return list.stream()
                .map(rankTop100DAO -> {
                    RankTop100UserResponseDTO dto = mapperBean.to(rankTop100DAO, RankTop100UserResponseDTO.class);
                    UserLogResponseDTO user = mapperBean.to(userGetByIdSmallBean.exec(rankTop100DAO.getUserId()), UserLogResponseDTO.class);
                    dto.setUser(user);
                    return dto;
                })
                .collect(Collectors.toList());
    }
}
