package com.example.jsgamesbackendmain.Bean.SmallBean.UserBean;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserSignUpRequestDTO;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserCreateSmallBean {
    private final UserSaveSmallBean userSaveSmallBean;
    private final MajorMapperBean majorMapperBean;
    public UserDAO exec(UserSignUpRequestDTO userSignUpRequestDTO) {
        //ParentMajor set
        ParentMajor parentMajor = majorMapperBean.getParentMajor(userSignUpRequestDTO.getMajor());
        String userId = generateVersion5UUID("namespace", "name").toString();
        //UUID set
        UserDAO user = userSignUpRequestDTO.toDAO(userId, parentMajor);

        return userSaveSmallBean.exec(user);
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
