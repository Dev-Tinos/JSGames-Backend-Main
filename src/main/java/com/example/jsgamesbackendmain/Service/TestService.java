package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailSetBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetMajorBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetTop100UserBean;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestService {
    private final EmailSetBean emailClearBean;

    private final RankSetTop100UserBean rankSetTop100UserBean;

    private final RankSetMajorBean rankSetMajorBean;

    public String emailClear() {
        emailClearBean.exec();
        return "success";
    }

    public StateResponseDTO setRank() {
        rankSetTop100UserBean.exec();
        return StateResponseDTO.builder().state(true).build();
    }

    public StateResponseDTO setMajor() {
        return rankSetMajorBean.exec();
    }
}
