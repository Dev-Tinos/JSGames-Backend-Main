package com.example.jsgamesbackendmain.Repository;

import com.example.jsgamesbackendmain.Model.DAO.FriendRequestDAO;
import com.example.jsgamesbackendmain.Model.ENUM.FriendRequestState;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FriendRequestRepository extends JpaRepository<FriendRequestDAO, Long> {
    Page<FriendRequestDAO> findByUserIdOrderByCreatedAtDesc(String userId, Pageable pageable);

    //state가 PENDING인 것만 가져오기 AND FriendID로 찾기
    Page<FriendRequestDAO> findByFriendIdAndStateOrderByCreatedAtDesc(String friendId, FriendRequestState state, Pageable pageable);

    //deleteByUserIdAndFriendId
    void deleteByUserIdAndFriendId(String userId, String friendId);


    //FriendRequestDAO의 State를 REJECTED로 변경
    @Modifying
    @Query("UPDATE FriendRequestDAO fr SET fr.state = :state WHERE fr.userId = :userId AND fr.friendId = :friendId")
    void updateStateByUserIdAndFriendId(@Param("userId") String userId, @Param("friendId") String friendId, @Param("state") FriendRequestState state);

    Optional<FriendRequestDAO> findByUserIdAndFriendId(String userId, String friendId);
}