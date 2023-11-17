package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LogRepository extends JpaRepository<LogDAO, Long> {

    //GameId, UserId 조회
    Page<LogDAO> findByGameIdAndUserId(Long gameId, String userId, Pageable pageable);

    // INFINITE GameId로 페이징후 가져오기
    Page<LogDAO> findByGameIdOrderByGameScoreDesc(Long gameId, Pageable pageable);

    // GOAL GameId로 페이징후 가져오기
    // 목표 점수와 가까운 순으로 정렬
    @Query(value = "SELECT r FROM LogDAO r WHERE r.gameId = ?1 ORDER BY ABS(r.gameScore - ?2) ASC, r.logId ASC")
    Page<LogDAO> findByGameIdOrderByGameScoreWithTargetScore(Long gameId, Double targetScore, Pageable pageable);

    // UserId로 페이징후 가져오기
    Page<LogDAO> findByUserIdOrderByGameScoreDesc(String userId, Pageable pageable);

    // GameId UserId 중 gameScore가 가장큰 튜플 가져오기
    Optional<LogDAO> findFirstByGameIdAndUserIdOrderByGameScoreDesc(Long gameId, String userId);

    // GameId UserId 중 targetScore와 gameScore의 차이가 가장 적은 튜플 가져오기
    @Query("SELECT r FROM LogDAO r WHERE r.gameId = ?1 AND r.userId = ?2 ORDER BY ABS(r.gameScore - ?3)")
    Page<LogDAO> findFirstByGameIdAndUserIdOrderByGameScoreWithTargetScore(Long gameId, String userId, Double targetScore, Pageable pageable);
    @Query("select count(r) from LogDAO r where r.gameScore >= ?1 and r.gameId = ?2")
    Long getRankInfinite(Double gameScore, Long gameId);

    @Query("select count(r) from LogDAO r where abs(?1 - r.gameScore) <= abs(?1 - ?2) and r.gameId = ?3")
    Long getRankGoal(Double targetScore, Double gameScore, Long gameId);
}
