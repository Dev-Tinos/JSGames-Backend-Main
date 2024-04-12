package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserSearchByNicknameSmallBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserSearchByNicknameResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class GetUsersByName {
    private final UserSearchByNicknameSmallBean userSearchByNicknameSmallBean;

    public List<UserSearchByNicknameResponseDTO> exec(String nickname, Integer page, Integer size) {
        List<UserDAO> users = userSearchByNicknameSmallBean.exec(nickname, page, size);

        return users.stream().map(UserSearchByNicknameResponseDTO::of)
                .collect(Collectors.toList());
    }
}
