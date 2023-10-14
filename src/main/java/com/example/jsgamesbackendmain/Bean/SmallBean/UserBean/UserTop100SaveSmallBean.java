package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.UserWeight.UserWeightDTO;
import com.example.jsgamesbackendmain.Repository.UserTop100Repository;
import com.example.jsgamesbackendmain.Repository.UserWeightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserTop100SaveSmallBean {
    @Autowired
    private UserWeightRepository userWeightRepository;
    @Autowired
    private UserTop100Repository userTop100Repository;
    public void exec() {
        List<UserWeightDTO> weightDTOList = userWeightRepository.findUserWeightSum(PageRequest.of(0, 100)).toList();
        for (UserWeightDTO weightDTO : weightDTOList) {
            userTop100Repository.save(UserTop100DAO.of(weightDTO.getUserId(), weightDTO.getWeightSum()));
        }
    }
}
