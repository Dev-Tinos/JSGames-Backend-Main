package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.ReportReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReviewDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportReviewRepository extends JpaRepository<ReportReviewDAO, Long> {

    Optional<ReportReviewDAO> findByReportedReviewAndReporter(ReviewDAO reviewDAO, UserDAO userDAO);
}
