package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<GameDAO, Long> {

    // 게임 조회수 순으로 정렬
    Page<GameDAO> findAllByOrderByViewCountDescGameIdAsc(Pageable pageable);

    // 게임 Log 갯수순으로 정렬
    @Query("select g from GameDAO g order by g.logs.size desc, g.gameId")
    Page<GameDAO> findAllByOrderByLogCountDescGameIdAsc(Pageable pageable);

    // 게임 생성일 순으로 정렬
    Page<GameDAO> findAllByOrderByCreatedAtDescGameIdAsc(Pageable pageable);

    // 게임 리뷰 갯수순으로 정렬
    @Query("select g from GameDAO g order by g.reviews.size desc, g.gameId")
    Page<GameDAO> findAllByOrderByReviewCountDescGameIdAsc(Pageable pageable);

    // userId가 플레이한 게임 의 log중 가장 최근에 gameId 조회
    @Query("select g from GameDAO g left join g.logs l where l.user = ?1 group by g.gameId order by max(l.createdAt) desc, g.gameId asc")
    Page<GameDAO> findAllByPlayedUserOrderByCreatedAtDescGameIdAsc(UserDAO user, Pageable pageable);
}