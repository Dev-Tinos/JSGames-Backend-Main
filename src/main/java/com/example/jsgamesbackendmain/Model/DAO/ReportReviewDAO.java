package com.example.jsgamesbackendmain.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@Table(name = "report_review")
public class ReportReviewDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportReviewId;

    // 신고당한 리뷰
    @OneToOne(fetch = FetchType.LAZY)
    private ReviewDAO reportedReview;

    // 신고한 유저
    @OneToOne(fetch = FetchType.LAZY)
    private UserDAO reporter;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
