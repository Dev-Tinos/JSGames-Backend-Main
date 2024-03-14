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
@NoArgsConstructor
@Builder
@Getter
@Table(name = "report_log")
public class ReportLogDAO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reportLogId;

    // 신고한 유저
    @OneToOne(fetch = FetchType.LAZY)
    private UserDAO reporter;

    // 신고당한 LogDAO
    @OneToOne(fetch = FetchType.LAZY)
    private LogDAO reportedLog;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
