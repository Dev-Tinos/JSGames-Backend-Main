package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {
}