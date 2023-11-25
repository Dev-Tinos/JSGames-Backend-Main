package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDAO, Long> {

    Page<ReviewDAO> findByGameIdOrderByHelpfulDescDateTimeDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByStarDescDateTimeDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeDescReviewIdDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeAscReviewIdDesc(Long gameId, Pageable pageable);
}