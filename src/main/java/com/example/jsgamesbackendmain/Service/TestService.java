package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailClearBean;
import com.example.jsgamesbackendmain.Bean.RankBean.RankSetTop100UserBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private EmailClearBean emailClearBean;

    @Autowired
    private RankSetTop100UserBean rankSetTop100UserBean;

    public String emailClear(){
        emailClearBean.exec();
        return "success";
    }
    public Map<String ,String > setRank() {
        rankSetTop100UserBean.exec();
        HashMap<String , String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
