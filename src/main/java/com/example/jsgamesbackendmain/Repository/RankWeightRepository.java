package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.RankWeightDAO;
import com.example.jsgamesbackendmain.Model.DTO.UserWeight.RankWeightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RankWeightRepository extends JpaRepository<RankWeightDAO, Long> {
    // GameId가 일치하는 UserWeightDAO중 UserId마다 Weight의 합을 구한다.
    // 그리고 그 합을 내림차순으로 정렬한다.
    @Query("SELECT new com.example.jsgamesbackendmain.Model.DTO.UserWeight.RankWeightDTO(u.userId, SUM(u.weight)) FROM RankWeightDAO u GROUP BY u.userId ORDER BY SUM(u.weight) DESC")
    Page<RankWeightDTO> findRankWeightSum(Pageable pageable);
}