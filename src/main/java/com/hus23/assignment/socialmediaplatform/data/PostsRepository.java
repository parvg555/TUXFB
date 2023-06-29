package com.hus23.assignment.socialmediaplatform.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query(nativeQuery = true, value = "select * from posts where user_id = :userId order by created_at asc;")
    List<Posts> getPostsByUserId(Integer userId);

    @Query(nativeQuery = true, value = "select * from posts where location = :location order by created_at asc;")
    List<Posts> getPostsByLocation(String location);


}
