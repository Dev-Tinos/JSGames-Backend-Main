package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Component
public class UserImageUpdateSmallBean {
    @Autowired
    private UserImageUploadSmallBean userImageUploadSmallBean;
    @Autowired
    private UserImageDeleteSmallBean userImageDeleteSmallBean;

    public String exec(String userId, String userEmail, MultipartFile image) throws IOException {
        userImageDeleteSmallBean.exec(userId);
        return userImageUploadSmallBean.exec(userEmail, image);
    }
}
