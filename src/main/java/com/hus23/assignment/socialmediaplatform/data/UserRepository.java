package com.hus23.assignment.socialmediaplatform.data;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value= "Update users set \n" +
            "user_name = :username,\n" +
            "last_name = :lastName,\n" +
            "first_name = :firstName,\n" +
            "email = :email  \n" +
            "where id = :userId ;")
    void updateUser(
                String username,
                String firstName,
                String lastName,
                String email,
                Integer userId
            );

    @Modifying
    @Transactional
    @Query(nativeQuery = true, value = "Update users set \n" +
            " password = :newPassword \n" +
            " where id = :userId ;")
    void updatePassword(String newPassword, Integer userId);
}
