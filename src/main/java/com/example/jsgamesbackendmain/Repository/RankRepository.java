package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.RankTop100DAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RankRepository extends JpaRepository<RankTop100DAO, Long> {
    // 전체중 Score로 내림차순
    Page<RankTop100DAO> findAllByOrderByScoreDesc(Pageable pageable);

}
