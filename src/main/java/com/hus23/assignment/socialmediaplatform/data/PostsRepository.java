package com.hus23.assignment.socialmediaplatform.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(nativeQuery = true, value = "select * from posts where user_id = :userId order by created_at asc;")
    List<Posts> getPostsByUserId(Integer userId);

    @Query(nativeQuery = true, value = "select * from posts where location = :location order by created_at asc;")
    List<Posts> getPostsByLocation(String location);

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value= "update POSTS set " +
            "content = :content, " +
            "location = :location " +
            "where id = :postId ;")
    void updatePostById(
            @Param("content") String content,
            @Param("location") String location,
            @Param("postId") Integer postId
    );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "delete from POSTS where user_id = :userId ;")
    void deleteAllPostsByUserId(Integer userId);

}
