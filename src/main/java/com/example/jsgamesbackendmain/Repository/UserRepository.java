package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, String> {
    Optional<UserDAO> findByEmail(String email);

    Optional<UserDAO> findByPassword(String password);

    List<UserDAO> findAllByNicknameContainingIgnoreCaseOrderByLastPlayTimeDescUserIdDesc(String nickname, Pageable pageable);
}