package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.LogDAO;
import com.example.jsgamesbackendmain.Model.DAO.ReportLogDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ReportLogRepository extends JpaRepository<ReportLogDAO, Long> {

    Optional<ReportLogDAO> findByReportedLogAndReporter(LogDAO log, UserDAO reporter);
}
