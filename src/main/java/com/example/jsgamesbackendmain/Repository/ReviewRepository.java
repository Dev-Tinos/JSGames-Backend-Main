package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewDAO, Long> {
    Page<ReviewDAO> findByGameIdOrderByDateTimeDesc(Long gameId, Pageable pageable);

    //reviewID 의 helpful +1
    @Modifying
    @Transactional
    @Query("UPDATE ReviewDAO r SET r.helpful = r.helpful + 1 WHERE r.reviewId = ?1")
    void updateHelpfulPlus(Long reviewId);

    //reviewID 의 helpful -1
    @Modifying
    @Transactional
    @Query("UPDATE ReviewDAO r SET r.helpful = r.helpful - 1 WHERE r.reviewId = ?1")
    void updateHelpfulMinus(Long reviewId);

    Page<ReviewDAO> findByGameIdOrderByHelpfulDescDateTimeDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByStarDescDateTimeDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeDescReviewIdDesc(Long gameId, Pageable pageable);
    Page<ReviewDAO> findByGameIdOrderByDateTimeAscReviewIdDesc(Long gameId, Pageable pageable);
}