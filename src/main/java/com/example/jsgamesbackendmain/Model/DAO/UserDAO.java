package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.UserBean.UesrCreateBean;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
public class UserDAO {
    @Id
    private String userId;
    private String nickname;
    private String email;
    private String password;
    private String profileImage = "https://pbs.twimg.com/media/EA9UJBjU4AAdkCm.jpg";
    @Enumerated(EnumType.STRING)
    private ParentMajor parentMajor;
    @Enumerated(EnumType.STRING)
    private Major major;

    public static UserDAO createTest(int i) {
        Major[] majors = Major.values();
        MajorMapperBean mapperBean = new MajorMapperBean();
        String id = UesrCreateBean.generateVersion5UUID("namespace", "name").toString();
        String s = String.valueOf(i);
        UserDAO dao = new UserDAO();
        dao.setUserId(id);
        dao.setNickname(s);
        dao.setProfileImage(s);
        dao.setMajor(majors[i % majors.length]);
        dao.setParentMajor(mapperBean.getParentMajor(dao.getMajor()));
        dao.setEmail(s);
        dao.setPassword(s);

        return dao;
    }
}
