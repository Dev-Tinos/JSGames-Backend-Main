package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.DoubleStream;

@Repository
public interface LogRepository extends JpaRepository<LogDAO, Long> {

    // GameId for Count
    Long countByGame(GameDAO game);

    //GameId, UserId 조회
    Page<LogDAO> findByGameAndUser(GameDAO game, UserDAO user, Pageable pageable);

    // INFINITE GameId로 페이징후 가져오기
    Page<LogDAO> findByGameOrderByGameScoreDesc(GameDAO game, Pageable pageable);

    // GOAL GameId로 페이징후 가져오기
    // 목표 점수와 가까운 순으로 정렬
    @Query(value = "SELECT r FROM LogDAO r WHERE r.game = ?1 ORDER BY ABS(r.gameScore - ?2) ASC, r.logId ASC")
    Page<LogDAO> findByGameOrderByGameScoreWithTargetScore(GameDAO game, Double targetScore, Pageable pageable);

    // UserId로 페이징후 가져오기
    Page<LogDAO> findByUserOrderByGameScoreDesc(UserDAO user, Pageable pageable);

    // GameId UserId 중 gameScore가 가장큰 튜플 가져오기
    Optional<LogDAO> findFirstByGameAndUserOrderByGameScoreDesc(GameDAO game, UserDAO user);

    // GameId UserId 중 targetScore와 gameScore의 차이가 가장 적은 튜플 가져오기
    @Query("SELECT r FROM LogDAO r WHERE r.game = ?1 AND r.user = ?2 ORDER BY ABS(r.gameScore - ?3)")
    Page<LogDAO> findFirstByGameIdAndUserIdOrderByGameScoreWithTargetScore(GameDAO game, UserDAO user, Double targetScore, Pageable pageable);
    @Query("select count(r) from LogDAO r where r.gameScore >= ?1 and r.game = ?2")
    Long getRankInfinite(Double gameScore, GameDAO game);

    @Query("select count(r) from LogDAO r where abs(?1 - r.gameScore) <= abs(?1 - ?2) and r.game = ?3")
    Long getRankGoal(Double targetScore, Double gameScore, GameDAO game);

    //유저가 플레이한 가장 최근 게임의 시간값 하나
    @Query("select max(r.createdAt) from LogDAO r where r.user = ?1")
    LocalDateTime getRecentPlay(UserDAO user);
}
