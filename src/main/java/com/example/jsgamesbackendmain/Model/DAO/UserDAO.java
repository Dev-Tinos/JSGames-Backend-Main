package com.example.jsgamesbackendmain.Model.DAO;

import com.example.jsgamesbackendmain.Bean.MapperBean.MajorMapperBean;
import com.example.jsgamesbackendmain.Bean.SmallBean.UserBean.UserCreateSmallBean;
import com.example.jsgamesbackendmain.Model.DTO.User.Request.UserUpdateRequestDTO;
import com.example.jsgamesbackendmain.Model.ENUM.Major;
import com.example.jsgamesbackendmain.Model.ENUM.ParentMajor;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDAO {
    @Setter
    @Id
    @Column(name = "user_id", length = 50)
    private String userId;
    private String nickname;
    private String email;
    private String password;
    @Builder.Default
    private String profileImageURL = "https://tinos-images-storage.s3.ap-northeast-2.amazonaws.com/default_user_image.png";
    @Enumerated(EnumType.STRING)
    private ParentMajor parentMajor;
    @Enumerated(EnumType.STRING)
    private Major major;

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<GameDAO> games = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<LogDAO> logs = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<ReviewDAO> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<FriendDAO> users = new ArrayList<>();

    @OneToMany(mappedBy = "friend", cascade = CascadeType.ALL)
    private List<FriendDAO> friends = new ArrayList<>();

    public UserDAO update(UserUpdateRequestDTO request, ParentMajor parentMajor) {
        if (request.getNickname() != null) {
            this.nickname = request.getNickname();
        }
        if (request.getMajor() != null) {
            this.major = request.getMajor();
            this.parentMajor = parentMajor;
        }

        if (request.getProfileImageURL() != null) {
            this.profileImageURL = request.getProfileImageURL();
        }
        return this;
    }

    public static UserDAO createTest(int i) {
        Major[] majors = Major.values();
        MajorMapperBean mapperBean = new MajorMapperBean();
        String id = UserCreateSmallBean.generateVersion5UUID("namespace", "name").toString();

        return UserDAO.builder()
                .userId(id)
                .nickname(String.valueOf(i))
                .major(majors[i % majors.length])
                .parentMajor(mapperBean.getParentMajor(majors[i % majors.length]))
                .email(String.valueOf(i))
                .password(String.valueOf(i))
                .build();
    }
}
