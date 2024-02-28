package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserSearchByNicknameSmallBean {
    private final UserRepository userRepository;

    public List<UserDAO> exec(String nickname, Integer page, Integer size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return userRepository.findAllByNicknameContainingIgnoreCaseOrderByLastPlayTimeDescUserIdDesc(nickname, pageRequest);
    }
}
