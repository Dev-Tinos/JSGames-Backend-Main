package com.example.jsgamesbackendmain.Service;

import com.example.jsgamesbackendmain.Bean.UserBean.*;
import com.example.jsgamesbackendmain.Model.DAO.UserTop100DAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.*;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserLoginRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserGetBean userGetBean;

    @Autowired
    private UserUpdateBean userUpdateBean;

    @Autowired
    private UserDeleteBean userDeleteBean;

    @Autowired
    private UserSignUpBean userSignUpBean;

    @Autowired
    private UserLoginBean userLoginBean;

    @Autowired
    private UserGetTop100Bean userGetTop100Bean;

    @Autowired
    private UserSetTop100Bean userSetTop100Bean;

    public UserGetResponseDTO getUser(Long userId) {
        return userGetBean.getUser(userId);
    }

    public UserUpdateResponseDTO updateUser(UserUpdateRequestDTO userUpdateRequestDTO) {
        return userUpdateBean.updateUser(userUpdateRequestDTO);
    }

    public Map<String,String> deleteUser(Long userId) {
        return userDeleteBean.deleteUser(userId);
    }

    public UserSignUpResponseDTO signUpUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        return userSignUpBean.signUpUser(userSignUpRequestDTO);
    }

    public UserLoginResponseDTO loginUser(UserLoginRequestDTO userLoginRequestDTO){
        return userLoginBean.exec(userLoginRequestDTO);
    }
    public List<UserGetTop100ResponseDTO> getTop100User(Long page, Long size) {
        List<UserTop100DAO> daoList = userGetTop100Bean.exec(page, size);
        return daoList.stream().map(UserGetTop100ResponseDTO::of).collect(Collectors.toList());
    }

    public Map<String ,String > setTop100User() {
        userSetTop100Bean.exec();
        HashMap<String , String> map = new HashMap<>();
        map.put("result", "success");
        return map;
    }
}
