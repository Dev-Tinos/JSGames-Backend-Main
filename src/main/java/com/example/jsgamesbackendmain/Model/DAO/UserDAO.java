package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UesrCreateSmallBean;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Id
    @Column(name = "user_id", length = 50)
    private String userId;
    private String nickname;
    private String email;
    private String password;
    private String profileImageURL = "https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png";
    @Enumerated(EnumType.STRING)
    private ParentMajor parentMajor;
    @Enumerated(EnumType.STRING)
    private Major major;

    public static UserDAO createTest(int i) {
        Major[] majors = Major.values();
        MajorMapperBean mapperBean = new MajorMapperBean();
        String id = UesrCreateSmallBean.generateVersion5UUID("namespace", "name").toString();
        String s = String.valueOf(i);
        UserDAO dao = new UserDAO();
        dao.setUserId(id);
        dao.setNickname(s);
        dao.setProfileImageURL(s);
        dao.setMajor(majors[i % majors.length]);
        dao.setParentMajor(mapperBean.getParentMajor(dao.getMajor()));
        dao.setEmail(s);
        dao.setPassword(s);

        return dao;
    }
}
