package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.EmailBean.EmailClearBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UserSetTop100Bean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TestService {
    @Autowired
    private EmailClearBean emailClearBean;

    @Autowired
    private UserSetTop100Bean userSetTop100Bean;

    public String emailClear(){
        emailClearBean.exec();
        return "success";
    }
    public Map<String ,String > setTop100User() {
        userSetTop100Bean.exec();
        HashMap<String , String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
