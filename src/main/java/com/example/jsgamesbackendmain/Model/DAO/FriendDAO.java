package com.example.jsgamesbackendmain.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "friend")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FriendDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserDAO user;

    @ManyToOne
    @JoinColumn(name = "friend_id")
    private UserDAO friend;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
