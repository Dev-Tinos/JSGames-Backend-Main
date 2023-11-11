package com.example.jsgamesbackendmain.Model.DAO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comments")
@Getter @Setter
@ToString
public class CommentDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private Long userId;
    private Long gameId;
    private String commentContent;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime dateTime;
}
