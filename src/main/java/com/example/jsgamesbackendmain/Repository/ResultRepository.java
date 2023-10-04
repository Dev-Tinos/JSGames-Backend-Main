package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ResultDAO;
import com.example.jsgamesbackendmain.Model.DTO.Result.Response.ResultGetByUserIdResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<ResultDAO, Long> {

    List<ResultDAO> findByGameId(Long gameId);

    List<ResultGetByUserIdResponseDTO> findByUserId(Long userId);

    // GameId로 페이징후 가져오기
    Page<ResultDAO> findByGameIdOrderByGameScoreDesc(Long gameId, Pageable pageable);

    // UserId로 페이징후 가져오기
    Page<ResultDAO> findByUserIdOrderByGameScoreDesc(Long userId, Pageable pageable);
}
