package com.example.jsgamesbackendmain.Converter;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Reponse.UserGetResponseDTO;

public class UserConverter {
    public static UserGetResponseDTO toUserGetResponseDTO(UserDAO dao) {
        UserGetResponseDTO dto = new UserGetResponseDTO();

        dto.setUserId(dao.getUserId());
        dto.setNickname(dao.getNickname());
        dto.setEmail(dao.getEmail());
        dto.setProfileImageURL(dao.getProfileImageURL());
        dto.setParentMajor(dao.getParentMajor());
        dto.setMajor(dao.getMajor());

        return dto;
    }
}
