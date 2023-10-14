package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.UserWeightDAO;
import com.example.jsgamesbackendmain.Model.DTO.UserWeight.UserWeightDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserWeightRepository extends JpaRepository<UserWeightDAO, Long> {
    // GameId가 일치하는 UserWeightDAO중 UserId마다 Weight의 합을 구한다.
    // 그리고 그 합을 내림차순으로 정렬한다.
    @Query("SELECT new com.example.jsgamesbackendmain.Model.DTO.UserWeight.UserWeightDTO(u.userId, SUM(u.userWeight)) FROM UserWeightDAO u GROUP BY u.userId ORDER BY SUM(u.userWeight) DESC")
    Page<UserWeightDTO> findUserWeightSum(Pageable pageable);
}