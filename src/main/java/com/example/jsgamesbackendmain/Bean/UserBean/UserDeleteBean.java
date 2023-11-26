package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.S3Bean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class UserDeleteBean {

    @Autowired
    private UserGetSmallBean userGetSmallBean;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private S3DeleteSmallBeam s3DeleteSmallBeam;
    public Map<String, String> deleteUser(String userId) {
        UserDAO user = userGetSmallBean.getUser(userId);
        if(!user.getProfileImageURL().equals("https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png")){
            s3DeleteSmallBeam.exec(user.getProfileImageURL());
        }
        userRepository.delete(user);
        HashMap<String,String> map = new HashMap<>();
        map.put("message","Success");
        return map;
    }
}
