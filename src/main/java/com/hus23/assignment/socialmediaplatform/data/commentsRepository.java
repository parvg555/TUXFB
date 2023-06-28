package com.hus23.assignment.socialmediaplatform.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface commentsRepository extends JpaRepository<comments, Long> {

}