package com.hus23.assignment.socialmediaplatform.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
        value = "delete from follows where follower_id = :userId and following_id = :followingId ;"
    )
    void unfollow(Integer userId, Integer followingId);

}