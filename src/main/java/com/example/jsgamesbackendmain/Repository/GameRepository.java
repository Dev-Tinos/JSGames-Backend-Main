package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.GameDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<GameDAO, Long> {

    // 게임 조회수 순으로 정렬
    Page<GameDAO> findAllByOrderByViewCountDescGameIdAsc(Pageable pageable);

    // GameDAO 의 logDAO중 userId가 일치하는 게임 조회 (userId가 존재하는 게임 조회)
    @Query("select g from GameDAO g where g.gameId in " +
            "(select l.game from LogDAO l where l.user = ?1) " +
            "order by g.viewCount desc, g.gameId")
    Page<GameDAO> findAllByPlayedUserOrderByViewCountDescGameIdAsc(UserDAO user, Pageable pageable);

    // 게임 전체 페이징 조회
    Page<GameDAO> findAll(Pageable pageable);
}