package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.ImageBean.S3DeleteSmallBeam;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserDeleteSmallBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserGetByIdSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.StateResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDeleteBean {

    @Autowired
    private UserGetByIdSmallBean UserGetByIdSmallBean;

    @Autowired
    private UserDeleteSmallBean userDeleteSmallBean;

    @Autowired
    private S3DeleteSmallBeam s3DeleteSmallBeam;
    public StateResponseDTO exec(String userId) {
        UserDAO user = UserGetByIdSmallBean.exec(userId);
        if(!user.getProfileImageURL().equals("https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png")){
            s3DeleteSmallBeam.exec(user.getProfileImageURL());
        }
        userDeleteSmallBean.exec(userId);
        return new StateResponseDTO(true);
    }
}
