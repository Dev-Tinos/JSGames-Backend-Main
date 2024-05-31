package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.FriendDAO;
import com.example.jsgamesbackendmain.Model.DAO.UserDAO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepository extends JpaRepository<FriendDAO, Long> {
    //deleteByUserAndFriend
    void deleteByUserAndFriend(UserDAO user, UserDAO friend);

    //findByUserIdOrderByCreatedAtDesc
    Page<FriendDAO> findByUserOrderByCreatedAtDesc(UserDAO user, Pageable pageable);

    @Query("SELECT f FROM FriendDAO f WHERE f.user.userId = :userId ORDER BY f.friend.lastPlayTime DESC")
    Page<FriendDAO> findFriendsByUserIdSortedByLastPlayTime(String userId, Pageable pageable);

    boolean existsByUserAndFriend(UserDAO user, UserDAO friend);

}
