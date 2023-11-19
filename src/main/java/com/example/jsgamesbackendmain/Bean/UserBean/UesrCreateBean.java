package com.example.jsgamesbackendmain.Bean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.MapperBean.MapperBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
public class UesrCreateBean {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MapperBean mapperBean;
    @Autowired
    private MajorMapperBean majorMapperBean;
    public UserDAO postUser(UserSignUpRequestDTO userSignUpRequestDTO) {
        UserDAO userDAO = mapperBean.to(userSignUpRequestDTO, UserDAO.class);
        //ParentMajor set
        userDAO.setParentMajor(majorMapperBean.getParentMajor(userSignUpRequestDTO.getMajor()));
        //UUID set
        userDAO.setUserId(generateVersion5UUID("namespace", "name").toString());
        return userRepository.save(userDAO);
    }
    public static UUID generateVersion5UUID(String namespace, String name) {
        try {
            MessageDigest salt = MessageDigest.getInstance("SHA-1");
            salt.update(namespace.getBytes(StandardCharsets.UTF_8));
            byte[] hash = salt.digest(name.getBytes(StandardCharsets.UTF_8));

            ByteBuffer buffer = ByteBuffer.wrap(hash);
            long high = buffer.getLong();
            long low = buffer.getLong();

            high = (high & 0xffff0fffL) | 0x00005000L; // Set version to 5
            low = (low & 0x3fffffffL) | 0x80000000L;  // Set variant to IETF

            return new UUID(high, low);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Unable to generate version 5 UUID", e);
        }
    }
}
