package com.hus23.assignment.socialmediaplatform.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentsRepository extends JpaRepository<Comments, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value= "Update comments set \n" +
            "content = :content \n" +
            "where id = :postId ;")
    void updateComment(
            String content,
            Integer postId
    );


}