package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailSetBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetTop100UserBean;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class TestService {
    private final EmailSetBean emailClearBean;

    private final RankSetTop100UserBean rankSetTop100UserBean;

    public String emailClear() {
        emailClearBean.exec();
        return "success";
    }

    public Map<String, String> setRank() {
        rankSetTop100UserBean.exec();
        HashMap<String, String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
