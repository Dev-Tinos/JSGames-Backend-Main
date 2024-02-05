package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendDAO, Long> {
    //deleteByUserAndFriend
    void deleteByUserAndFriend(UserDAO user, UserDAO friend);

    //findByUserIdOrderByCreatedAtDesc
    Page<FriendDAO> findByUserOrderByCreatedAtDesc(UserDAO user, Pageable pageable);
}
