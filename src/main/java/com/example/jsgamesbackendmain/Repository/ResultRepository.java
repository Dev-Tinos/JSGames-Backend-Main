package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.ResultDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultRepository extends JpaRepository<ResultDAO, Long> {
}
