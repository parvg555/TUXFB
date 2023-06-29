package com.hus23.assignment.socialmediaplatform.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface FollowsRepository extends JpaRepository<Follows, Long> {

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
        value = "delete from follows where follower_id = :userId and following_id = :followingId ;"
    )
    void unfollow(Integer userId, Integer followingId);

    @Query(nativeQuery = true,
        value = "select follower_id from follows where following_id = :userId ;"
    )
    List<Integer> getFollowers(Integer userId);

    @Query(nativeQuery = true,
            value = "select following_id from follows where follower_id = :userId ;"
    )
    List<Integer> getFollowing(Integer userId);

    @Query(nativeQuery = true,
        value="select following_id from follows where follower_id = :user1 and following_id = :user2 ;"
    )
    List<Integer> isMyFollower(long user1, long user2);

}