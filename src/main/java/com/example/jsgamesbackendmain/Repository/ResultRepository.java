package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<ResultDAO, Long> {

    List<ResultDAO> findByGameId(Long gameId);

    List<ResultGetByUserIdResponseDTO> findByUserId(Long userId);

    // INFINITE GameId로 페이징후 가져오기
    Page<ResultDAO> findByGameIdOrderByGameScoreDesc(Long gameId, Pageable pageable);

    // GOAL GameId로 페이징후 가져오기
    // 목표 점수와 가까운 순으로 정렬
    @Query(value = "SELECT r FROM ResultDAO r WHERE r.gameId = ?1 ORDER BY ABS(r.gameScore - ?2) ASC")
    Page<ResultDAO> findByGameIdOrderByGameScoreWithTargetScore(Long gameId, Double targetScore, Pageable pageable);

    // UserId로 페이징후 가져오기
    Page<ResultDAO> findByUserIdOrderByGameScoreDesc(Long userId, Pageable pageable);
}
